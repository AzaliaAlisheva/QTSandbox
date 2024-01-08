package org.example;

import io.qt.core.*;
import io.qt.gui.QIcon;
import io.qt.widgets.*;

import java.util.Objects;

public class Main{

    public static void main(String[] args) {
        QApplication.initialize(args); // creating an instance of QApplication
        QFile styleFile = new QFile(":/dark.qss");
        if (!styleFile.open(QIODeviceBase.OpenModeFlag.ReadOnly)) {
            QMessageBox.warning(null, "Warning", "Cannot open file: " + styleFile.errorString());
            return;
        }
        MainWindow mainWindow = new MainWindow();
        mainWindow.setStyleSheet(String.valueOf(styleFile.readAll()));

        mainWindow.show();
        styleFile.close();

        QApplication.exec();
        QApplication.shutdown(); // deleting instance of QApplication
    }
}
