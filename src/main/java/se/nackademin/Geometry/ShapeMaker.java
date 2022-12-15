package se.nackademin.Geometry;

import java.util.ArrayList;
import java.util.List;


public class ShapeMaker {

    Shapes myshapes;

    List<Shapes> shapesList= new ArrayList<>();

    public ShapeMaker(){
        shapesList.add(new ShapesDiamond());
        shapesList.add(new ShapesFlower());
        shapesList.add(new ShapesEllips());
        shapesList.add(new ShapesRectangle());

       // Collections.shuffle(shapesList);
        myshapes = shapesList.get(0);
    }

    public Shapes getMyshapes() {
        return myshapes;
    }

    public List<Shapes> getShapesList() {
        return shapesList;
    }
}
