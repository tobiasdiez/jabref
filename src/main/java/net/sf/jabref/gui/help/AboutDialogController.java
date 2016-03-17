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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.sf.jabref.Globals;
import net.sf.jabref.JabRef;
import net.sf.jabref.gui.ClipBoardManager;
import net.sf.jabref.gui.desktop.JabRefDesktop;
import net.sf.jabref.logic.l10n.Localization;

public class AboutDialogController {

    public StringProperty aboutYearProperty() {
        return aboutYear;
    }

    public String getAboutYear() {
        return aboutYear.get();
    }

    private final StringProperty aboutYear;

    public final StringProperty aboutWebsiteProperty;

    public AboutDialogController() {
        String year = String.format("2003-%s", Globals.BUILD_INFO.getYear());
        this.aboutYear = new SimpleStringProperty(year);

        this.aboutWebsiteProperty = new SimpleStringProperty("http://www.jabref.org");
    }

    @FXML
    private void openJabrefWebsite() {
        aboutYear.set("Open website " + aboutWebsiteProperty.get());
    }
}
