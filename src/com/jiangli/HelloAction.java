package com.jiangli;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * @author Jiangli
 * @date 2017/12/29 15:55
 */
public class HelloAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        //当前工程对象
        Project project = e.getData(PlatformDataKeys.PROJECT);

        System.out.println("显示对话框111");

        //显示一个对话框，让用户输入名字
        String msg = Messages.showInputDialog(project, "你的名字?", "titlehahaha", Messages.getQuestionIcon());

        System.out.println("得到名称:"+msg);

        Messages.showMessageDialog(project,"你好"+msg,"titleaaasdsad",Messages.getInformationIcon());
    }
}
