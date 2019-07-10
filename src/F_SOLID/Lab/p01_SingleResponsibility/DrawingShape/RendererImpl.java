package F_SOLID.Lab.p01_SingleResponsibility.DrawingShape;

import F_SOLID.Lab.p01_SingleResponsibility.DrawingShape.interfaces.Renderer;
import F_SOLID.Lab.p01_SingleResponsibility.DrawingShape.interfaces.Shape;

public class RendererImpl implements Renderer {

    @Override
    public void render(Shape shape) {
        System.out.println("Draw shape");
    }
}
