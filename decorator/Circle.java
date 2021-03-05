import java.util.stream.Stream;

interface Shape {
    void draw();
    double area();
}


class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle");    
    }

	@Override
	public double area() {
		return 100;
	}

}

class Rectange implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectanguler");
    }

	@Override
	public double area() {
		return 200;
	}

}

/////////////////////////
// Decorator pattern 
//

abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }

    @Override
    public double area() {
        return shape.area();
    }
}


class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }
    

    @Override
    public void draw() {
        this.setRedBorder();
        super.draw();
    }

    private void setRedBorder() {
        System.out.println("Red Border");
    }


}


class BlueShapeDecorator extends ShapeDecorator {

    public BlueShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }

    @Override
    public void draw() {
        super.draw();
        this.setBlueBorder();

    }

    private void setBlueBorder() {
        System.out.println("Blue Border");
    }
}


/////////////////////////////////////////////
// Decorator Pattern using Lambda Functions

interface Decorator {
    void decorate();
}

class ShapeDecorator2 implements Shape {
    private Shape shape;
    private Decorator[] decorators;

    public ShapeDecorator2(Shape shape, Decorator... decorators) {
        this.shape = shape;
        this.decorators = decorators;
    }

	@Override
	public void draw() {
       this.shape.draw();
       Stream.of(this.decorators).forEach(Decorator::decorate);
    }

	@Override
	public double area() {
		return this.shape.area();
	}
}

class ShapeDecoratorFunctions {
    public static void withRedBoarder() {
        System.out.println("with Red Boarder");
    }

    public static void withBlueBoarder() {
        System.out.println("with Blue Boarder");
    }
}
