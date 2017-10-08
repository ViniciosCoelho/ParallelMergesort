package Utilities.UI

import java.awt.Color
import javax.swing.JButton
import javax.swing.JFrame

class UIWindow : JFrame("Parallel Mergesort") {
    init {
        initFrame()

        add(initButton())
    }

    private fun initFrame() {
        setSize(400, 300)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        layout = null
        setLocationRelativeTo(null)
        setVisible(true)
    }

    private fun initButton(): JButton {
        val buttonRun = JButton("Run")

        buttonRun.setBounds(150, 240, 100, 25)
        buttonRun.background = Color.LIGHT_GRAY
        buttonRun.setVisible(true)

        return buttonRun
    }

//     private initFirst
}