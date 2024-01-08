/********************************************************************************
 * Form generated from reading UI file 'main.ui'
 *
 * Created by: QtJambi User Interface Compiler version 6.6.1
 *
 * WARNING! All changes made in this file will be lost when recompiling UI file!
 *******************************************************************************/

package org.example;

import io.qt.core.*;
import io.qt.gui.*;
import io.qt.widgets.*;

public class Ui_MainWindow {

    public QAction fileNewAction;
    public QAction actionOpen;
    public QAction actionClose;
    public QAction actionClose_all;
    public QAction actionSave;
    public QAction actionSave_as;
    public QAction actionSave_all;
    public QAction actionDump_memory;
    public QAction actionExit;
    public QWidget centralwidget;
    public QHBoxLayout horizontalLayout;
    public QTableWidget tableWidget;
    public QMenuBar menubar;
    public QMenu menuFile;
    public QMenu menuEdit;
    public QMenu menuRun;
    public QMenu menuSettings;
    public QMenu menuTools;
    public QMenu menuHelp;
    public QStatusBar statusbar;

    public void setupUi(QMainWindow mainWindow){
        if (mainWindow.objectName().isEmpty())
            mainWindow.setObjectName("MainWindow");
        mainWindow.resize(856, 663);
        mainWindow.setStyleSheet("");
        this.fileNewAction = new QAction(mainWindow);
        this.fileNewAction.setObjectName("fileNewAction");
        this.actionOpen = new QAction(mainWindow);
        this.actionOpen.setObjectName("actionOpen");
        this.actionClose = new QAction(mainWindow);
        this.actionClose.setObjectName("actionClose");
        this.actionClose_all = new QAction(mainWindow);
        this.actionClose_all.setObjectName("actionClose_all");
        this.actionSave = new QAction(mainWindow);
        this.actionSave.setObjectName("actionSave");
        {
            QIcon icon = new QIcon();
            icon.addFile(":/MenuIcons/icons/disk.png", new QSize(), QIcon.Mode.Normal, QIcon.State.Off);
            this.actionSave.setIcon(icon);
        }
        this.actionSave_as = new QAction(mainWindow);
        this.actionSave_as.setObjectName("actionSave_as");
        {
            QIcon icon1 = new QIcon();
            icon1.addFile(":/MenuIcons/icons/disk--plus.png", new QSize(), QIcon.Mode.Normal, QIcon.State.Off);
            this.actionSave_as.setIcon(icon1);
        }
        this.actionSave_all = new QAction(mainWindow);
        this.actionSave_all.setObjectName("actionSave_all");
        {
            QIcon icon2 = new QIcon();
            icon2.addFile(":/MenuIcons/icons/disks.png", new QSize(), QIcon.Mode.Normal, QIcon.State.Off);
            this.actionSave_all.setIcon(icon2);
        }
        this.actionDump_memory = new QAction(mainWindow);
        this.actionDump_memory.setObjectName("actionDump_memory");
        this.actionExit = new QAction(mainWindow);
        this.actionExit.setObjectName("actionExit");
        {
            QIcon icon3 = new QIcon();
            icon3.addFile(":/MenuIcons/icons/door--arrow.png", new QSize(), QIcon.Mode.Normal, QIcon.State.Off);
            this.actionExit.setIcon(icon3);
        }
        this.centralwidget = new QWidget(mainWindow);
        this.centralwidget.setObjectName("centralwidget");
        this.horizontalLayout = new QHBoxLayout(this.centralwidget);
        this.horizontalLayout.setObjectName("horizontalLayout");
        this.tableWidget = new QTableWidget(this.centralwidget);
        this.tableWidget.setObjectName("tableWidget");

        this.horizontalLayout.addWidget(this.tableWidget);
        mainWindow.setCentralWidget(this.centralwidget);
        this.menubar = new QMenuBar(mainWindow);
        this.menubar.setObjectName("menubar");
        this.menubar.setGeometry(new QRect(0, 0, 856, 22));
        this.menuFile = new QMenu(this.menubar);
        this.menuFile.setObjectName("menuFile");
        this.menuEdit = new QMenu(this.menubar);
        this.menuEdit.setObjectName("menuEdit");
        this.menuRun = new QMenu(this.menubar);
        this.menuRun.setObjectName("menuRun");
        this.menuSettings = new QMenu(this.menubar);
        this.menuSettings.setObjectName("menuSettings");
        this.menuTools = new QMenu(this.menubar);
        this.menuTools.setObjectName("menuTools");
        this.menuHelp = new QMenu(this.menubar);
        this.menuHelp.setObjectName("menuHelp");
        mainWindow.setMenuBar(this.menubar);
        this.statusbar = new QStatusBar(mainWindow);
        this.statusbar.setObjectName("statusbar");
        mainWindow.setStatusBar(this.statusbar);

        this.menubar.addAction(this.menuFile.menuAction());
        this.menubar.addAction(this.menuEdit.menuAction());
        this.menubar.addAction(this.menuRun.menuAction());
        this.menubar.addAction(this.menuSettings.menuAction());
        this.menubar.addAction(this.menuTools.menuAction());
        this.menubar.addAction(this.menuHelp.menuAction());
        this.menuFile.addAction(this.fileNewAction);
        this.menuFile.addAction(this.actionOpen);
        this.menuFile.addAction(this.actionClose);
        this.menuFile.addAction(this.actionClose_all);
        this.menuFile.addSeparator();
        this.menuFile.addAction(this.actionSave);
        this.menuFile.addAction(this.actionSave_as);
        this.menuFile.addAction(this.actionSave_all);
        this.menuFile.addAction(this.actionDump_memory);
        this.menuFile.addSeparator();
        this.menuFile.addAction(this.actionExit);

        this.retranslateUi(mainWindow);

        QMetaObject.connectSlotsByName(mainWindow);
    }

    public void retranslateUi(QMainWindow mainWindow)
    {
        mainWindow.setWindowTitle(io.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        this.fileNewAction.setText(io.qt.core.QCoreApplication.translate("MainWindow", "New", null));
        this.actionOpen.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Open", null));
        this.actionClose.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Close", null));
        this.actionClose_all.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Close all", null));
        this.actionSave.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Save", null));
        this.actionSave_as.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Save as", null));
        this.actionSave_all.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Save all", null));
        this.actionDump_memory.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Dump memory", null));
        this.actionExit.setText(io.qt.core.QCoreApplication.translate("MainWindow", "Exit", null));
        this.menuFile.setTitle(io.qt.core.QCoreApplication.translate("MainWindow", "File", null));
        this.menuEdit.setTitle(io.qt.core.QCoreApplication.translate("MainWindow", "Edit", null));
        this.menuRun.setTitle(io.qt.core.QCoreApplication.translate("MainWindow", "Run", null));
        this.menuSettings.setTitle(io.qt.core.QCoreApplication.translate("MainWindow", "Settings", null));
        this.menuTools.setTitle(io.qt.core.QCoreApplication.translate("MainWindow", "Tools", null));
        this.menuHelp.setTitle(io.qt.core.QCoreApplication.translate("MainWindow", "Help", null));
    }
}

