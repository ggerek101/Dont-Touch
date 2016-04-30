package pl.touch.matiko101.Game.Box2D;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import pl.touch.matiko101.Game.Objects.*;

/**
 * Created by mateusz on 2016-04-15.
 */
public class CollisionDetection implements ContactListener
{
    @Override
    public void beginContact(Contact contact)
    {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();

        if(bodyA.getUserData() == "hero" && bodyB.getUserData() == "line")
        {
            Hero h = (Hero) bodyA.getUserData();
            h.getPhysicsContent().setShouldChangeDirection(true);
        }
        if(bodyA.getUserData() == "line" && bodyB.getUserData() == "hero")
        {
            Hero h = (Hero) bodyB.getUserData();
            h.getPhysicsContent().setShouldChangeDirection(true);
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
