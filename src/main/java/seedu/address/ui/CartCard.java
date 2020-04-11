package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.ingredient.Ingredient;

/**
 * An UI component that displays information of a {@code Cart}.
 */
public class CartCard extends UiPart<Region> {

    private static final String FXML = "CartCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Ingredient ingredient;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label quantity;

    public CartCard(Ingredient ingredient, int displayedIndex) {
        super(FXML);
        this.ingredient = ingredient;
        id.setText(displayedIndex + ". ");
        name.setText(ingredient.getName().ingredientName);
        quantity.setText(ingredient.getQuantity().value + " " + ingredient.getQuantity().unit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CartCard)) {
            return false;
        }

        // state check
        CartCard card = (CartCard) other;
        return id.getText().equals(card.id.getText())
                && ingredient.equals(card.ingredient);
    }
}
