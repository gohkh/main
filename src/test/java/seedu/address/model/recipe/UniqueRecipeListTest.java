package seedu.address.model.recipe;

import org.junit.jupiter.api.Test;
import seedu.address.model.recipe.exceptions.DuplicateRecipeException;
import seedu.address.model.recipe.exceptions.RecipeNotFoundException;

import java.text.RuleBasedCollator;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalRecipes.CARBONARA;
import static seedu.address.testutil.TypicalRecipes.SCRAMBLED_EGG;

public class UniqueRecipeListTest {

    private final UniqueRecipeList uniqueRecipeList = new UniqueRecipeList();

    @Test
    public void containsNullRecipeThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.contains(null));
    }

    @Test
    public void contains_recipeNotInList_returnsFalse() {
        assertFalse(uniqueRecipeList.contains(CARBONARA));
    }

    @Test
    public void contains_recipeInList_returnsTrue() {
        uniqueRecipeList.add(CARBONARA);
        assertTrue(uniqueRecipeList.contains(CARBONARA));
    }

    @Test
    public void add_nullRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.add(null));
    }

    @Test
    public void add_duplicateRecipe_throwsDuplicateRecipeException() {
        uniqueRecipeList.add(CARBONARA);
        assertThrows(DuplicateRecipeException.class, () -> uniqueRecipeList.add(CARBONARA));
    }

    @Test
    public void setRecipe_nullTargetRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(null, CARBONARA));
    }

    @Test
    public void setRecipe_nullEditedRecipe_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueRecipeList.setRecipe(CARBONARA, null));
    }

    @Test
    public void setRecipe_targetRecipeNotInList_throwsRecipeNotFoundException() {
        assertThrows(RecipeNotFoundException.class, () -> uniqueRecipeList.setRecipe(CARBONARA, CARBONARA));
    }

    @Test
    public void setPerson_editedRecipeIsSameRecipe_success() {
        uniqueRecipeList.add(CARBONARA);
        uniqueRecipeList.setRecipe(CARBONARA, CARBONARA);
        UniqueRecipeList expectedUniqueRecipeList = new UniqueRecipeList();
        expectedUniqueRecipeList.add(CARBONARA);
        assertEquals(expectedUniqueRecipeList, uniqueRecipeList);
    }
}
