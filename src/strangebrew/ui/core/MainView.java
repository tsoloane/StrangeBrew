/*
 * Created on Oct 14, 2004
 */
package strangebrew.ui.core;

/**
 * @author mike
 *
 */
public abstract class MainView extends View {

	public abstract RecipeNavigationView getRecipeNavigationView();
	public abstract RecipeDetailsView getRecipeDetailsView(String title);
	
}