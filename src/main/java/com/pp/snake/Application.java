package com.pp.snake;

import com.pp.snake.model.Direction;
import com.pp.snake.presenter.Game;
import com.pp.snake.view.GamePanel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Application {

  public static void main(String... args) {
    EventQueue.invokeLater(Application::start);
  }

  private static void start() {
    Game game = new Game();
    Toolkit.getDefaultToolkit().addAWTEventListener(e -> {
      KeyEvent ke = KeyEvent.class.cast(e);
      Direction direction = (ke.getKeyCode() == KeyEvent.VK_LEFT) ? Direction.LEFT
        : (ke.getKeyCode() == KeyEvent.VK_RIGHT) ? Direction.RIGHT : (ke.getKeyCode() == KeyEvent.VK_UP) ? Direction.UP : (ke.getKeyCode() == KeyEvent.VK_DOWN) ? Direction.DOWN : null;
      if(direction != null) {
        game.setNextDirection(direction);
      }
    }, AWTEvent.KEY_EVENT_MASK);
    GamePanel gamePanel = new GamePanel(game::getSnakePoints, game::getFieldHeight, game::getFieldWidth);
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    game.start(gamePanel::repaint);
  }

}
