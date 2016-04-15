package pl.touch.matiko101;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pl.touch.matiko101.Menu.Menu;

public class Main extends Game {
	
	@Override
	public void create () {
		this.setScreen(new Menu(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
