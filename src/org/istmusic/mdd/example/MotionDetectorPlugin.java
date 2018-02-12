package org.istmusic.mdd.example;

import org.istmusic.mdd.plugins.MDDContextReasonerPlugin;
import org.istmusic.mdd.dmcs.DMC;
import org.istmusic.mdd.dmcs.DMCFactory;
import org.istmusic.mdd.dmcs.DMC_Element;
import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.plugins.IContextPlugin;

import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.model.impl.ContextValueMap;
import org.istmusic.mw.context.model.impl.MetadataMap;

import java.util.HashMap;
import org.istmusic.mdd.operators.Operator;

//These imports are added by the MDD - some of them are added through inspecting the ontology and the
//grounding of some data types
import org.istmusic.mdd.operators.ImageComparingOperator;
import java.awt.image.BufferedImage;

/**
 * A simple example of a plugin. It takes as input context (the Image captured
 * by the Webcamp) and generates context (percentage of change between 2
 * consecutive --and nearby in terms of time-- images).
 *
 * This plugin consists of 3 simple stages (connectors):
 * <ol>
 * <li>The input context (triggerred asynchronously) is copied into a DMC
 *        queue with 2 elements</li>
 * <li>An operator processes the input (when the queue is full) and
 *        generates a double value indicating the difference of the two images
 *        in the queue, and stored in a single-element DMC</li>
 * <li>When changed, the generated value (in the single-element DMC) is
 *        encoded to a Context Element accordingly and forwarded to the context
 *        manager</li>
 * </ol>
 *
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
public class MotionDetectorPlugin extends MDDContextReasonerPlugin
{

	// this field to be constructed automatically by the MDD transformation
    public static final String PLUGIN_ID = "MddMotionDetectorPlugin";

    // this field to be constructed automatically by the MDD transformation
    public static final MotionDetectorPluginMetadata MOTION_DETECTOR_PLUGIN_METADATA =
            new MotionDetectorPluginMetadata();
    
    //create operators
    protected static final Operator Op_ImageComparatorOperator = new ImageComparingOperator();    
    {
    //parameterize operator	
    	((ImageComparingOperator) Op_ImageComparatorOperator).setLowerThreshold(0.2d);    
    }
   
    
    //ToDo: Check if problems arise from different TTL semantics in a DMC chain
   
    //create DMCs
    protected static final DMC MotionDetectorPlugin_Input = DMCFactory.createDMC_SingleElement(DMC.LIVE_FOREVER); 
    protected static final DMC MotionDetectorPlugin_Output = DMCFactory.createDMC_SingleElement(DMC.LIVE_FOREVER);
    protected static final DMC ImageComparatorOperator_Input = DMCFactory.createDMC_Queue(2, 1000L);
    protected static final DMC ImageComparatorOperator_Output = DMCFactory.createDMC_SingleElement(DMC.LIVE_FOREVER);

    private static HashMap entityScopePairToDMCMap = new HashMap();    
    {
    	entityScopePairToDMCMap.put(MotionDetectorPluginMetadata.Input_WEBCAM_IMAGE_ENTITY_SCOPE_PAIR, MotionDetectorPlugin_Input);
    
    
    }	
 
    public MotionDetectorPlugin()
    {
        super(PLUGIN_ID, MOTION_DETECTOR_PLUGIN_METADATA, 1000L, 1000L);
    }
    
    
    //To be generated for event triggered context plugins
    public boolean checkDMCTriggerStatus(){
    
//    	if(MotionDetectorPlugin_Input.getStatus().contains(DMC.STATUS_NEW_ELEMENT))
//    		return true;
  
    	return false;
    }
    
    public void contextChanged(ContextChangedEvent event)
    {
            final IContextElement [] contextElements = event.getContextDataset().getContextElements();
            for(int i = 0; i < contextElements.length; i++)
            {
                final IContextElement contextElement = contextElements[i];
                final EntityScopePair entityScopePair = new EntityScopePair(
                        contextElement.getEntity(), contextElement.getScope());

                DMC_Element element = DMCFactory.createDMC_Element(contextElement, -1L);

                DMC curr_DMC = (DMC) entityScopePairToDMCMap.get(entityScopePair);
                
                if(curr_DMC != null){
                	try{
                		curr_DMC.insert(element);
                	}
                	catch(Exception e){
                		
                		//ToDo: This has to be modified to something that makes sense
                	}
                }
                   
            }
    }
    

    public void compute(){
    	
    	MotionDetectorPlugin_Input_to_ImageComparatorOperator_Input_Mediator.mediate(MotionDetectorPlugin_Input, ImageComparatorOperator_Input);
    	
    	Op_ImageComparatorOperator.compute(new DMC[]{ImageComparatorOperator_Input}, ImageComparatorOperator_Output);
    	
    	ImageComparatorOperator_Output_to_MotionDetectorPlugin_Output_Mediator.mediate(ImageComparatorOperator_Output, MotionDetectorPlugin_Output, this);
    	
    	
        final IContextDataset contextDataset = Factory.createContextDataset((IContextElement[]) MotionDetectorPlugin_Output.getAllValues());
        contextListener.contextChanged(EventFactory.createContextChangedEvent(contextDataset, contextDataset));

    }
 
    
    //connector link is annotated with: 
    //#concept.contextscope.abstract.ImageBuffer 
    //#representation:java.awt.Image
    //-> 
    //#representation:JavaType.ByteArray
    private static class MotionDetectorPlugin_Input_to_ImageComparatorOperator_Input_Mediator{
   
    	public static void mediate(final DMC fromDC, final DMC toDMC){
    		
    		IContextElement fromElement = (IContextElement) fromDC.get(0).getValue();
    		
    		BufferedImage toElement = (BufferedImage) fromElement.getContextData().getValue(Factory.createScope("#concept.contextscope.abstract.ImageBuffer"));
    		
    		try {
    			toDMC.insert(DMCFactory.createDMC_Element(toElement, -1L));
    		}
    		catch(Exception e) {
    			//ToDo: This has to be reworked with something that makes sense    			
    		}
    		
    	}
    	
    }
    
    //connector link is annotated with
    //#representation.environment.Boolean
    //->
    //#concept.contextscope.abstract.TrueFalseFlag
    //#representation.environment.Boolean
    private static class ImageComparatorOperator_Output_to_MotionDetectorPlugin_Output_Mediator{
    
    	public static void mediate(final DMC fromDC, final DMC toDMC, IContextPlugin plugin){
    		
    		Boolean fromElement = ((Boolean) fromDC.get(0).getValue());
    		
    		HashMap valueHashMap = new HashMap();
    		
    		//ToDo: Invoke Factory only once and save result into variables
    		IContextValue contextValue_0 = Factory.createContextValue(
    				Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag"),
    				Factory.createRepresentation("#representation.environment.Boolean"),
    				Factory.createValue(fromElement.booleanValue()),
                    (IMetadata) MetadataMap.EMPTY_METADATA_MAP);


    		valueHashMap.put(Factory.createScope("#concept.contextscope.abstract.TrueFalseFlag"), contextValue_0);
    		
    		ContextValueMap contextValueMap = Factory.createContextValueMap(valueHashMap);
    		
    		IContextElement toElement = Factory.createContextElement(
    				MotionDetectorPluginMetadata.Output_MOTION_DETECTED_ENTITY,
    				MotionDetectorPluginMetadata.Output_MOTION_DETECTED_SCOPE,
    				MotionDetectorPluginMetadata.Output_MOTION_DETECTED_REPRESENTATION,
    				plugin,
    				contextValueMap);
    		
    		try {
    			toDMC.insert(DMCFactory.createDMC_Element(toElement, -1L));
    		}
    		catch(Exception e) {
    			//ToDo: This has to be reworked with something that makes sense    			
    		}
    		
    	}
    	
    	
    	
    }
    
    
}