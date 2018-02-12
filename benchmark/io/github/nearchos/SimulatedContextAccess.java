package io.github.nearchos;

import org.istmusic.mw.context.IContextAccess;
import org.istmusic.mw.context.cqp.queryapi.IContextQuery;
import org.istmusic.mw.context.events.ContextChangedEvent;
import org.istmusic.mw.context.events.EventFactory;
import org.istmusic.mw.context.events.IContextListener;
import org.istmusic.mw.context.events.UninterceptedContextChangedEvent;
import org.istmusic.mw.context.exceptions.ContextException;
import org.istmusic.mw.context.model.api.*;
import org.istmusic.mw.context.model.impl.ContextDataset;
import org.istmusic.mw.context.model.impl.ContextValueMap;
import org.istmusic.mw.context.model.impl.Factory;
import org.istmusic.mw.context.plugins.IContextPlugin;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class SimulatedContextAccess implements IContextAccess, IContextListener {

    @Override
    public IContextDataset queryContext(IEntity iEntity, IScope iScope) throws ContextException {
        throw new NotImplementedException();
    }

    @Override
    public IContextElement queryContextLastElement(IEntity iEntity, IScope iScope) throws ContextException {
        throw new NotImplementedException();
    }

    @Override
    public IContextValue queryContextLastValue(IEntity iEntity, IScope iScope, IScope iScope1) throws ContextException {
        throw new NotImplementedException();
    }

    @Override
    public void queryContext(IEntity iEntity, IScope iScope, IContextListener iContextListener) throws ContextException {
        throw new NotImplementedException();
    }

    @Override
    public IContextDataset queryContext(IContextQuery iContextQuery) throws ContextException {
        throw new NotImplementedException();
    }

    @Override
    public void queryContext(IContextQuery iContextQuery, IContextListener iContextListener) throws ContextException {
        throw new NotImplementedException();
    }

    final Map<EntityScopePair, Vector<IContextListener>> contextListenersMap = new HashMap<>();

    @Override
    public void addContextListener(IEntity entity, IScope scope, IContextListener contextListener) throws ContextException {
        final EntityScopePair entityScopePair = new EntityScopePair(entity, scope);
        final Vector<IContextListener> contextListeners = contextListenersMap.getOrDefault(entityScopePair, new Vector<>());
        contextListeners.add(contextListener);
        contextListenersMap.put(entityScopePair, contextListeners);
    }

    @Override
    public void removeContextListener(IEntity entity, IScope scope, IContextListener contextListener) throws ContextException {
        final EntityScopePair entityScopePair = new EntityScopePair(entity, scope);
        final Vector<IContextListener> contextListeners = contextListenersMap.getOrDefault(entityScopePair, new Vector<>());
        final boolean removed = contextListeners.remove(contextListener);
        if(!removed) throw new ContextException("The specified listener was not registered for the given entity/scope pair: " + entityScopePair);
    }

    @Override
    public void addNeededContextType(IEntity entity, IScope scope, Object o) throws ContextException {
        throw new NotImplementedException();
    }

    @Override
    public void removeNeededContextType(IEntity entity, IScope scope, Object o) throws ContextException {
        throw new NotImplementedException();
    }

    void register(IContextPlugin contextPlugin) {
        contextPlugin.setContextAccessService(this);
        contextPlugin.setContextListener(this);
//        final EntityScopePair [] requiredEntityScopePairs = contextPlugin.getMetadata().getRequiredEntityScopePairs();
//        for(final EntityScopePair entityScopePair : requiredEntityScopePairs) {
//            addContextListener(entityScopePair.getEntity(), entityScopePair.getScope(), contextPlugin);
//        }
    }

    void simulateContextEvent(final Object source, IEntity entity, IScope scope, IRepresentation representation, IValue value) {
        final Map<IScope, IContextValue> map = new HashMap<>();
        map.put(scope, Factory.createContextValue(scope, representation, value, IMetadata.EMPTY_METADATA));
        final ContextValueMap contextValueMap = Factory.createContextValueMap(map);
        final IContextElement contextElement = Factory.createContextElement(entity, scope, representation, source, contextValueMap);
        IContextDataset contextDataset = Factory.createContextDataset(contextElement);
        final ContextChangedEvent contextChangedEvent = EventFactory.createContextChangedEvent(source, contextDataset);
        simulateContextEvent(contextChangedEvent);
    }

    void simulateContextEvent(final ContextChangedEvent contextChangedEvent) {
        final IContextElement [] contextElements = contextChangedEvent.getContextElements();
        for(final IContextElement contextElement : contextElements) {
            final EntityScopePair entityScopePair = new EntityScopePair(contextElement.getEntity(), contextElement.getScope());
            final Vector<IContextListener> contextListeners = contextListenersMap.getOrDefault(entityScopePair, new Vector<>());
            for(final IContextListener contextListener : contextListeners) {
                contextListener.contextChanged(contextChangedEvent);
            }
        }
    }

    @Override
    public void contextChanged(ContextChangedEvent contextChangedEvent) {
        final IContextElement [] contextElements = contextChangedEvent.getContextElements();
        if(contextElements != null) {
            for(final IContextElement contextElement : contextElements) {
                final IEntity entity = contextElement.getEntity();
                final IScope scope = contextElement.getScope();
                final EntityScopePair entityScopePair = new EntityScopePair(entity, scope);

                final Vector<IContextListener> contextListeners = contextListenersMap.getOrDefault(entityScopePair, new Vector<>());
                for(final IContextListener contextListener : contextListeners) {
                    contextListener.contextChanged(contextChangedEvent);
                }
            }
        }
    }
}