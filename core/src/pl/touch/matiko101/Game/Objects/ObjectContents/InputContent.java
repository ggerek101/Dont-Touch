package pl.touch.matiko101.Game.Objects.ObjectContents;

import com.badlogic.gdx.Gdx;

/**
* Created by mateusz on 2016-04-22.
*/
public abstract class InputContent implements Content
{
    public boolean touchedScreen()
    {
        return Gdx.input.isTouched();
    }
}
