package org.istmusic.mdd.plugins;

import org.istmusic.mw.context.plugins.AbstractContextReasonerPlugin;
import org.istmusic.mw.context.plugins.IPluginMetadata;
import org.istmusic.mw.context.util.scheduler.RecurringEvent;
import org.istmusic.mw.context.util.scheduler.Scheduler;


/**
 * This is the core of the MDD-based plugins. The idea is that given a set of
 * needed {@link org.istmusic.mdd.connectors.Connector}s (which implicitly
 * specify the sets of needed {@link org.istmusic.mdd.dmcs.DMC}s and
 * {@link org.istmusic.mdd.operators.Operator}s as well, this class will
 * automatically provide the rest (by interpreting the desired behavior at
 * run-time).
 *
 * @author Nearchos Paspallis [npaspallis@uclan.ac.uk]
 */
abstract public class MDDContextReasonerPlugin
        extends AbstractContextReasonerPlugin
        implements Runnable
{
    
    protected boolean intervalTriggered = false;

    private RecurringEvent workerRecurringEvent = null; 

    public MDDContextReasonerPlugin(
            final String pluginID,
            final IPluginMetadata pluginMetadata)
    {
        super(pluginID, pluginMetadata);

        init();
    }
    
    public MDDContextReasonerPlugin(
            final String pluginID,
            final IPluginMetadata pluginMetadata,
            final long init_wait,
            final long interval)
    {
        super(pluginID, pluginMetadata);

        intervalTriggered = true;
        
        workerRecurringEvent = new RecurringEvent(this, init_wait, interval);
        
        init();
    }
    

    /**
     * Maps context (EntityScopePair type) to sets of ContextToDMC connectors.
     */

    private void init()
    {
        // parse triggers:
        //      1. for periodic triggers, insert events in the TupleSpace
        //      2. for OnValue triggers, update the context-to-connectors map
        /*for(int i = 0; i < connectors.length; i++)
        {
            final Connector connector = connectors[i];

            final Trigger trigger = connector.getTrigger();
            if(trigger instanceof PeriodicTrigger)
            {
                final PeriodicTrigger periodicTrigger = (PeriodicTrigger) trigger;
                insertTuple(new ScheduledTrigger(periodicTrigger.getInterval(), connector));
            }

            if(connector instanceof ContextToDMC)
            {
                final ContextToDMC contextToDMC = (ContextToDMC) connector;
                final EntityScopePair entityScopePair = contextToDMC.getEntityScopePair();
                Set connectors = (Set) contextToConnectors.get(entityScopePair);
                if(connectors == null)
                {
                    connectors = new HashSet();
                    contextToConnectors.put(entityScopePair, connectors);
                }
                connectors.add(connector);
            }
        }*/
    }

    public void activate()
    {
        // register to receive context changes as specified in the metadata
        super.activate();

        if(intervalTriggered)
        	Scheduler.getInstance().scheduleEvent(workerRecurringEvent);
    }

    public void deactivate()
    {
        // unregister from receiving context changes as specified in the metadata
        super.deactivate();

        if(intervalTriggered)
        	Scheduler.getInstance().removeRecurringEvent(workerRecurringEvent);
    }


    //abstract public void contextChanged(ContextChangedEvent event);
/*    {
        final IContextElement [] contextElements = event.getContextDataset().getContextElements();
        for(int i = 0; i < contextElements.length; i++)
        {
            final IContextElement contextElement = contextElements[i];
            final EntityScopePair entityScopePair = new EntityScopePair(
                    contextElement.getEntity(), contextElement.getScope());

            final Set connectorsForContext = (Set) contextToConnectors.get(entityScopePair);
            if(connectorsForContext != null)
            {
                Iterator connectorsIterator = connectorsForContext.iterator();
                while(connectorsIterator.hasNext())
                {
                    final ContextToDMC contextToDMCConnector = (ContextToDMC) connectorsIterator.next();
                    final DMC dmc = contextToDMCConnector.getDmc();

                    // todo copy context from 'contextElement' to 'dmc'

                    insertTuple(contextToDMCConnector);
                }
            }
        }
    }*/
    
    //In this method the actual computation are performed
    abstract public void compute();
    
    //This method is implemented by the actual Context Plugin and allows to check if the a relevant update
    //of a dmc has occurred.   
    abstract public boolean checkDMCTriggerStatus();
    
    
    public void checkEventTriggering(){
    	
    	if(checkDMCTriggerStatus())
    		compute();
    	
    }
    

    public void run()
    {
       compute();
    }


}