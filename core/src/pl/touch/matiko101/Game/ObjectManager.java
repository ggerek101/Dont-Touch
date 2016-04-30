package pl.touch.matiko101.Game;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactListener;

import java.util.Vector;

import pl.touch.matiko101.Game.Box2D.CollisionDetection;
import pl.touch.matiko101.Game.Box2D.MyWorld;
import pl.touch.matiko101.Game.Objects.*;
import pl.touch.matiko101.Game.Objects.Object;

/**
 * Created by mateusz on 2016-04-15.
 */
public class ObjectManager
{
    private MyWorld myWorld;

    private CollisionDetection collisionDetection;

   // private Vector<Object>objects;

    private Hero hero;
    private Line leftLine;
    private Line rightLine;

    public ObjectManager()
    {
        myWorld = new MyWorld();

        collisionDetection = new CollisionDetection();
        myWorld.world.setContactListener(collisionDetection);

       // objects = new Vector<Object>();

       // objects.add(new Hero(960, 600, "hero.png"));

        hero = new Hero(960, 600, "hero.png");
        hero.getPhysicsContent().setBody(myWorld.createObject(hero.getGraphicsContent().getSprite(), BodyDef.BodyType.DynamicBody), "hero");

        leftLine = new Line(0,0,"line.png");
        leftLine.getPhysicsContent().setBody(myWorld.createObject(leftLine.getGraphicsContent().getSprite(), BodyDef.BodyType.StaticBody), "line");

        rightLine = new Line(1820,0,"line.png");
        rightLine.getPhysicsContent().setBody(myWorld.createObject(rightLine.getGraphicsContent().getSprite(), BodyDef.BodyType.StaticBody), "line");
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
