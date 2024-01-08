package org.example;

import io.qt.NonNull;
import io.qt.core.*;
import io.qt.gui.QIcon;
import io.qt.widgets.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainWindow extends QMainWindow {
    public MainWindow() {
        QResource.registerResource(":/MainIcons.rcc");
        uiMainWindow = new Ui_MainWindow();
        uiMainWindow.setupUi(this);
        uiMainWindow.actionClose.triggered.connect(this, "onCloseClicked");
        uiMainWindow.actionClose_all.triggered.connect(this, "onCloseAllClicked");
        uiMainWindow.actionExit.triggered.connect(this, "close");
        uiMainWindow.fileNewAction.triggered.connect(this, "onNewClicked");
        uiMainWindow.actionOpen.triggered.connect(this, "onOpenClicked");
        uiMainWindow.actionSave.triggered.connect(this, "onSaveClicked");
        uiMainWindow.actionSave_as.triggered.connect(this, "onSaveAsClicked");

//        QSizePolicy sizePolicy = new QSizePolicy(QSizePolicy.Policy.Preferred, QSizePolicy.Policy.Preferred);
//        sizePolicy.setHorizontalStretch(50);
//        sizePolicy.setVerticalStretch(0);

        tabWidget = new QTabWidget(uiMainWindow.centralwidget);
        uiMainWindow.horizontalLayout.insertWidget(0, tabWidget);
        tabWidget.setObjectName("tabWidget");
        uiMainWindow.fileNewAction.setIcon(Objects.requireNonNull(this.style()).standardIcon(QStyle.StandardPixmap.SP_FileIcon));
        uiMainWindow.actionOpen.setIcon(Objects.requireNonNull(this.style()).standardIcon(QStyle.StandardPixmap.SP_FileDialogEnd));
        uiMainWindow.actionClose.setIcon(Objects.requireNonNull(this.style()).standardIcon(QStyle.StandardPixmap.SP_BrowserStop));
    }

    private void onCloseClicked() {
        if (tabWidget.currentIndex() == -1) {
            return;
        }
        tabWidget.removeTab(tabWidget.currentIndex());
        fileAddresses.remove(tabWidget.currentIndex());
    }

    private void onCloseAllClicked() {
        tabWidget.clear();
        fileAddresses.clear();
    }

    private QWidget createTab() {
        QWidget tab = new QWidget();
//        tab.setObjectName("tab_" + tabWidget.count());
//        tabWidget.setTabText(tabWidget.indexOf(tab),
//                io.qt.core.QCoreApplication.translate("MainWindow", "Tab " + tabWidget.count(), null));
        QVBoxLayout verticalLayout = new QVBoxLayout(tab);
        QPlainTextEdit plainTextEdit = new QPlainTextEdit("", tab);
        plainTextEdit.setObjectName("plain_text_edit");
        verticalLayout.addWidget(plainTextEdit);
        return tab;
    }

    private void onNewClicked() {
        tabWidget.addTab(createTab(), "file" + (tabWidget.count() + 1) + ".txt");
        fileAddresses.add(null);
    }
    private void onOpenClicked() {
        QFileDialog.Result<String> result = QFileDialog.getOpenFileName(this, "Open a file",
                "C:/", "Text file(*.txt) ;; Assembly file (*.asm)");
        if (result == null) { //not always false, IntelliJ IDEA is lying to you
            return;
        }
        String currentFile = result.result;
        QFile file = new QFile(currentFile);
        if (!file.open(QIODeviceBase.OpenModeFlag.ReadOnly)) {
            QMessageBox.warning(this, "Warning", "Cannot open file: " + file.errorString());
            return;
        }
        tabWidget.addTab(createTab(), new QFileInfo(file).fileName());
        fileAddresses.add(currentFile);
        ((QPlainTextEdit) Objects.requireNonNull(tabWidget.currentWidget().findChild("plain_text_edit"))).setPlainText(String.valueOf(file.readAll()));
        file.close();
    }

    private void onSaveClicked() {
        if (tabWidget.currentIndex() == -1) {
            return;
        }
        String currentFile = fileAddresses.get(tabWidget.currentIndex());
        if (currentFile == null) {
            onSaveAsClicked();
        } else {
            QFile file = new QFile(currentFile);
            if (!file.open(QFile.OpenModeFlag.WriteOnly)) {
                QMessageBox.warning(this, "Warning", "Cannot save file: " + file.errorString());
                return;
            }
            if (tabWidget.currentWidget() != null) {
                file.write(((QPlainTextEdit) Objects.requireNonNull(tabWidget.currentWidget().findChild("plain_text_edit"))).getPlainText().getBytes());
            }
            file.close();
        }
    }

    private void onSaveAsClicked() {
        if (tabWidget.currentIndex() == -1) {
            return;
        }
        String currentFile = QFileDialog.getSaveFileName(this, "Save as", "C:/" +
                tabWidget.tabText(tabWidget.currentIndex()), "Text file(*.txt) ;; Assembly file (*.asm)").result;
        if (currentFile == null) {
            return;
        }
        fileAddresses.set(tabWidget.currentIndex(), currentFile);
        tabWidget.setTabText(tabWidget.currentIndex(), new QFileInfo(currentFile).fileName());
        onSaveClicked();
    }

    private final Ui_MainWindow uiMainWindow;
    private final QTabWidget tabWidget;
    private final List<String> fileAddresses = new ArrayList<>();
}
