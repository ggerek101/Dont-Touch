package pl.touch.matiko101.Game.Box2D;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import pl.touch.matiko101.Game.Objects.Hero;
import pl.touch.matiko101.Game.Objects.Line;

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

        if(bodyA.getUserData() instanceof Hero && bodyB.getUserData() instanceof Line)
        {
            Hero h = (Hero) bodyA.getUserData();
            h.setChangeDirection(true);
        }
        if(bodyA.getUserData() instanceof Line && bodyB.getUserData() instanceof Hero)
        {
            Hero h = (Hero) bodyB.getUserData();
            h.setChangeDirection(true);
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
