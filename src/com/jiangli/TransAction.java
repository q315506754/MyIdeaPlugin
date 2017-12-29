package com.jiangli;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.BalloonBuilder;
import com.intellij.openapi.ui.popup.JBPopupFactory;

import java.awt.*;

/**
 * @author Jiangli
 * @date 2017/12/29 16:51
 */
public class TransAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Editor editor = e.getData(PlatformDataKeys.EDITOR);

        SelectionModel selectionModel = editor.getSelectionModel();

        String selectedText = selectionModel.getSelectedText();

        Messages.showMessageDialog(selectedText,"title",Messages.getErrorIcon());

        ApplicationManager.getApplication().invokeLater(() -> {
            Messages.showMessageDialog(selectedText,"later title",Messages.getErrorIcon());

            JBPopupFactory instance = JBPopupFactory.getInstance();
            BalloonBuilder builder = instance.createHtmlTextBalloonBuilder(" <ul id=\"nav\">\n" +
                    "    <li class=\"item1\"><a href=\"\">Item 1</a></li>\n" +
                    "    <li class=\"item2\"><a href=\"\">Item 2</a></li>\n" +
                    "    <li class=\"item3\"><a href=\"\">Item 3</a></li>\n" +
                    "    <li class=\"item4\"><a href=\"\">Item 4</a></li>\n" +
                    "  </ul>\n" +
                    "  <br>", null, Color.CYAN, e1 -> {

            });

            builder.setFadeoutTime(10_000).createBalloon().show(instance.guessBestPopupLocation(editor), Balloon.Position.below);
        });
    }
}
