/*  Copyright (C) 2003-2015 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/
package net.sf.jabref.gui.help;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import net.sf.jabref.JabRef;
import net.sf.jabref.JabRefMain;
import net.sf.jabref.gui.FXAlert;
import net.sf.jabref.logic.l10n.Localization;

public class AboutDialog extends FXAlert {

    private final Log logger = LogFactory.getLog(AboutDialog.class);


    public AboutDialog() {
        super(AlertType.INFORMATION, Localization.lang("About JabRef"));

        FXMLLoader fxmlLoader = new FXMLLoader();
        try (InputStream imageStream = JabRef.class.getResourceAsStream("/images/external/JabRef-icon-48.png");
                InputStream fxmlStream = JabRef.class.getResourceAsStream("/gui/help/AboutDialogLayout.fxml");) {
            DialogPane aboutDialogContentPane = (DialogPane) fxmlLoader.load(fxmlStream);
            Image jabRefIcon = new Image(imageStream);
            setDialogIcon(jabRefIcon);
            setDialogPane(aboutDialogContentPane);
            setDialogStyle(JabRefMain.class.getResource("/gui/help/AboutDialog.css").toExternalForm());
        } catch (IOException e) {
            logger.debug("AboutDialog could not be completely loaded!", e);
        }
    }

}
