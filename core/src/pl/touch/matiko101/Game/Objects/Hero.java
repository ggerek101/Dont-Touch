package pl.touch.matiko101.Game.Objects;

import com.badlogic.gdx.Gdx;

import pl.touch.matiko101.Graphics;

/**
 * Created by mateusz on 2016-04-15.
 */
public class Hero extends Object
{
    public enum Direction{LEFT, RIGHT}
    private enum TeleportTo{UP, DOWN, NULL}

    private float v;

    private Direction direction;
    private boolean changeDirection;

    private TeleportTo teleportTo;

    public Hero(float x, float y, String pathToFile)
    {
        super(x, y, pathToFile);

        v = 5;

        direction = Direction.LEFT;
        changeDirection = false;

        teleportTo = TeleportTo.NULL;

    }

    private void shouldChangeDirection()
    {
        if(changeDirection)
        {
            if(direction == Direction.LEFT)
            {
                direction = Direction.RIGHT;
            }
            else
            {
                direction = Direction.LEFT;
            }
            changeDirection = false;
        }
    }

    private void moveByDirection()
    {
        if(direction == Direction.RIGHT)
        {
            body.setLinearVelocity(v, body.getLinearVelocity().y);
        }
        else
        {
            body.setLinearVelocity(-v, body.getLinearVelocity().y);
        }
    }

    private boolean shouldJump()
    {
        if(Gdx.input.isTouched())
        {
            return true;
        }
        return false;
    }

    private void jump()
    {
        body.setLinearVelocity(body.getLinearVelocity().x, v);
    }

    private boolean shouldTeleport()
    {
        if(body.getPosition().y - sprite.getHeight() > Graphics.getCamera().viewportHeight)
        {
            teleportTo = TeleportTo.DOWN;
            return true;
        }
        else if(body.getPosition().y < 0)
        {
            teleportTo = TeleportTo.UP;
            return true;
        }
        teleportTo = TeleportTo.NULL;
        return false;
    }

    private void teleport()
    {
        switch (teleportTo)
        {
            case UP:
                body.setTransform(body.getPosition().x, Graphics.getCamera().viewportHeight + sprite.getHeight(), 0);
                break;
            case DOWN:
                body.setTransform(body.getPosition().x, 0, 0);
                break;
            case NULL:
                break;
        }
    }

    @Override
    public void action()
    {
        if(shouldJump())
        {
            jump();
        }
        if(shouldTeleport())
        {
            teleport();
        }
        shouldChangeDirection();
        moveByDirection();
    }

    public void setChangeDirection(boolean changeDirection)
    {
        this.changeDirection = changeDirection;
    }
}
