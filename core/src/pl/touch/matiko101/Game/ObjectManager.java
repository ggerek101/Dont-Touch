package pl.touch.matiko101.Game;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactListener;

import pl.touch.matiko101.Game.Box2D.CollisionDetection;
import pl.touch.matiko101.Game.Box2D.MyWorld;
import pl.touch.matiko101.Game.Objects.Hero;
import pl.touch.matiko101.Game.Objects.Line;

/**
 * Created by mateusz on 2016-04-15.
 */
public class ObjectManager
{
    private MyWorld myWorld;

    private CollisionDetection collisionDetection;

    private Hero hero;
    private Line leftLine;
    private Line rightLine;

    public ObjectManager()
    {
        myWorld = new MyWorld();

        collisionDetection = new CollisionDetection();
        myWorld.world.setContactListener(collisionDetection);

        hero = new Hero(960, 600, "hero.png");
        hero.setBody(myWorld.createObject(hero.getSprite(), BodyDef.BodyType.DynamicBody));

        leftLine = new Line(0,0,"line.png");
        leftLine.setBody(myWorld.createObject(leftLine.getSprite(), BodyDef.BodyType.StaticBody));

        rightLine = new Line(1820,0,"line.png");
        rightLine.setBody(myWorld.createObject(rightLine.getSprite(), BodyDef.BodyType.StaticBody));
    }

    public void update()
    {
        myWorld.update();
    }

    public Hero getHero()
    {
        return hero;
    }

    public Line getLeftLine()
    {
        return leftLine;
    }

    public Line getRightLine()
    {
        return rightLine;
    }
}
