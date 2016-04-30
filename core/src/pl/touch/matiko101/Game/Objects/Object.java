package pl.touch.matiko101.Game.Objects;

import pl.touch.matiko101.Game.Objects.ObjectContents.GraphicsContent;
import pl.touch.matiko101.Game.Objects.ObjectContents.InputContent;
import pl.touch.matiko101.Game.Objects.ObjectContents.PhysicsContent;

public abstract class Object
{
    protected GraphicsContent graphicsContent;
    protected PhysicsContent physicsContent;
    protected InputContent inputContent;

    public Object(float x, float y, String pathToFile)
    {
        graphicsContent = new GraphicsContent(x, y, pathToFile)
        {
            @Override
            public void action()
            {

            }

            @Override
            public void init()
            {
                initTextureContent();
                initSpriteContent();
            }
        };
        graphicsContent.init();
    }

    public abstract void action();

    public PhysicsContent getPhysicsContent()
    {
        return physicsContent;
    }
    public GraphicsContent getGraphicsContent()
    {
        return graphicsContent;
    }
}
