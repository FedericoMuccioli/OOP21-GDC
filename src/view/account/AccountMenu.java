package view.account;

import account.AccountManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import view.GridBagConstraintsConstructor;
import view.gui.MainGui;

public class AccountMenu {

    /**
     * 
     **/
    private static final long serialVersionUID = 1L;
    private final MainGui frame;
    private final AccountManager account;
    private final JPanel panel;
    private final JPanel panelAccount;
    private final JButton buttonBack;
    private final ActionListener alBackMenu;
    private ActionListener alBackPanel;
    
    public AccountMenu(final MainGui frame, final AccountManager account) {
        this.frame = frame;
        this.account = account;
        this.panel = new JPanel(new BorderLayout());
        this.panel.setPreferredSize(this.frame.getSize());
        this.buttonBack = new JButton("EXIT");
        this.alBackMenu = this.getActionListenerBackGamesMenu();
        this.buttonBack.addActionListener(alBackMenu);
        this.panel.add(buttonBack, BorderLayout.SOUTH);
        
//pannello PRINCIPALE
        this.panelAccount = new JPanel(new GridBagLayout());
        this.panelAccount.setBackground(new Color(68, 87, 96));
        this.panelAccount.setPreferredSize(frame.getSize());
        this.panel.add(panelAccount);
        final JLabel title = new JLabel("ACCOUNT", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, frame.getWidth() / 20));
        int index = 0;
        this.panelAccount.add(title, GridBagConstraintsConstructor.get(0, index++, 40));
        final JButton balanceManagement = new JButton("BALANCE");
        final JButton changeUsername = new JButton("CHANGE USERNAME");
        final JButton changePassword = new JButton("CHANGE PASSWORD");
        final JButton deleteAccount = new JButton("DELETE ACCOUNT");
        final List<JButton> list = new LinkedList<>();
        list.add(balanceManagement);
        list.add(changeUsername);
        list.add(changePassword);
        list.add(deleteAccount);
        for (final JButton jb : list) {
            jb.setPreferredSize(new Dimension(frame.getWidth() / 4, frame.getHeight() / 20));
            jb.setFont(new Font("Arial", Font.PLAIN, frame.getWidth() / 50));
            panelAccount.add(jb, GridBagConstraintsConstructor.get(0, index++, 5));
        }
        
        final BalancePanel panelBalance = new BalancePanel();
        final UsernamePanel panelUsername = new UsernamePanel(this.frame.getFrame());
        final PasswordPanel panelPassword = new PasswordPanel(this.frame.getFrame(), frame.getWidth(), frame.getHeight());

        balanceManagement.addActionListener(e -> {
            updatePanel(panelBalance);
        });

        changeUsername.addActionListener(e -> {
            updatePanel(panelUsername);
        });        

        changePassword.addActionListener(e -> {
            updatePanel(panelPassword);
        });
        
        deleteAccount.addActionListener(e -> {
            //aggiungere una volta eliminato account tornare menu d'accesso.
            
            final UpdatePanel p = new UpdatePanel() {
                @Override
                public void update() {
                    System.out.println("AccountDeleted");
                  //NICO 
                }
            };
//            new ConfirmPassword(dialog, p, 3, frame.getWidth() / 2, frame.getHeight());
        });
        
        
        frame.updateMenu(panel);
    }
    
    private void updatePanel(final JPanel panelToAdd) {
        changePanel(panelToAdd, this.panelAccount);
        this.alBackPanel = getActionListenerBackPanel(panelToAdd);
        changeActionListenerButtonBack(this.alBackPanel, this.alBackMenu);
    }
    
    private void changePanel(final JPanel panelToAdd, final JPanel panelToRemove) {
        this.panel.remove(panelToRemove);
        this.panel.add(panelToAdd);
        this.panel.revalidate();//controllare se serve
        this.panel.repaint();
    }
    
    private ActionListener getActionListenerBackPanel(final JPanel panelAdded) {
        return e -> {
            this.changePanel(this.panelAccount, panelAdded);
            this.changeActionListenerButtonBack(this.alBackMenu, this.alBackPanel);
        };
    }
    
    private void changeActionListenerButtonBack(final ActionListener alToAdd, final ActionListener alToRemove) {
        this.buttonBack.addActionListener(alToAdd);
        this.buttonBack.removeActionListener(alToRemove);
    }
    
    private ActionListener getActionListenerBackGamesMenu() {
        return e -> frame.setGamesMenu(account);
    }
    
}
/*Appunti*/
//final NumberFormat format = NumberFormat.getNumberInstance();
//final NumberFormat format = NumberFormat.getCurrencyInstance();
//final NumberFormat format = DecimalFormat.getCurrencyInstance();
//fieldRicarica.setName("Ricarica");
//fieldRicarica.setEditable(false); 
//labelRicarica.setLabelFor(fieldRicarica);