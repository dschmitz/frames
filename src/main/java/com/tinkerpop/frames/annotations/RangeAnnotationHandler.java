package com.tinkerpop.frames.annotations;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.frames.FramesManager;
import com.tinkerpop.frames.Range;

import java.lang.reflect.Method;

public class RangeAnnotationHandler implements AnnotationHandler<Range> {

    @Override
    public Class<Range> getAnnotationType() {
        return Range.class;
    }

    @Override
    public Object processVertex(Range annotation, Method method, Object[] arguments, FramesManager manager, Vertex element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object processEdge(Range annotation, Method method, Object[] arguments, FramesManager manager, Edge element, Direction direction) {
        if (direction.equals(Direction.OUT)) {
            return manager.frame(((Edge) element).getInVertex(), method.getReturnType());
        } else {
            return manager.frame(((Edge) element).getOutVertex(), method.getReturnType());
        }
    }

}
