package ch.fhnw.oop;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Biraveen on 03.12.2015.
 */
public class TabelCell extends TableCell<Resultat, String> {
    private static final Map<String, Image> WAPPEN = new HashMap<>();

    private static final Insets INSETS = new Insets(1, 8, 1, 5);

    @Override
    protected void updateItem(String item, boolean empty) {
        setText("");
        setGraphic(null);

        if (!empty) {
            Image img = WAPPEN.get(item);
            if (img == null) {
                try {
                    img = new Image(getClass().getResource("wappen_klein/" + item + ".png")
                            .toExternalForm(), 18, 18, true, true, true);
                    WAPPEN.put(item, img);
                } catch (NullPointerException e) {
                    img = new Image(getClass().getResource("wappen_klein/" + "noPicture" + ".jpg")
                            .toExternalForm(), 18, 18, true, true, true);
                    WAPPEN.put("noPicture", img);
                }

            }

            ImageView imageView = new ImageView(img);

            setGraphic(imageView);
            setTooltip(new Tooltip(item));
            setAlignment(Pos.CENTER);
            setPadding(INSETS);
        }

    }

}

