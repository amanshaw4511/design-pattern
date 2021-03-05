
interface Shape {
    void draw();
}


class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle");
    }

}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }

}


interface Color {
    void fill();
}

class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Red");
    }

}

class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Blue");
    }

}


interface AbstractFactory<T> {
    T getInstance(String type);
}

class FactoryProvider {
    public static AbstractFactory getFactory(String type) {
        if (type = null)
            return null;
        else if (type.equals("shape"))
            return new ShapeFactory();
        else if (type.equals("color"))
            return new ColorFactory();
        return null;
    }
}

class ShapeFactory implements AbstractFactory<Shape> {

    @Override
    public Shape getInstance(String type) {
        if (type == null) 
            return null;
        else if (type.equals("circle"))
            return new Circle();
        else if (type.equals("recatangle"))
            return new Rectangle();
        return null;
    }
    
}

class ColorFactory implements AbstractFactory<Color> {

    @Override
    public Color getInstance(String type) {
        if (type == null)
            return null;
        else if (type.equals("red"))
            return new Red();
        else if (type.equals("blue"))
            return new Blue();
        return null;
    }
    
}
