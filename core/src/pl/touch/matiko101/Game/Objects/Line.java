package pl.touch.matiko101.Game.Objects;

import pl.touch.matiko101.Game.Objects.ObjectContents.PhysicsContent;

/**
 * Created by mateusz on 2016-04-15.
 */
public class Line extends Object
{
    public Line(float x, float y, String pathToFile)
    {
        super(x, y, pathToFile);
        physicsContent = new PhysicsContent() {
            @Override
            public void action() {

            }

            @Override
            public void init() {

            }

        };
    }

    @Override
    public void action() {

    }
}
