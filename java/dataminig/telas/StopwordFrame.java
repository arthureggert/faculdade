package br.com.ahe.dataminig.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import utils.ASpringUtils;
import br.com.ahe.dataminig.actions.CancelarAction;
import br.com.ahe.dataminig.daos.StopwordDAO;
import br.com.ahe.dataminig.tables.Stopword;
import constants.AConstants;

public class StopwordFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField textFieldStopword;
	
	public StopwordFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 273, 106);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		
		JButton btnOk = new JButton("Cadastrar");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StopwordDAO dao = ASpringUtils.getBean( StopwordDAO.class );
				Stopword stopword = dao.create(new Stopword(StopwordFrame.this.textFieldStopword.getText()));
				JOptionPane.showMessageDialog(null, String.format("Cadastro realizado com sucesso \n%s",stopword.toString()));
				setVisible(false);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CancelarAction( AConstants.HIDE, this));
		
		JLabel lblStopword = new JLabel("Stopword");
		
		this.textFieldStopword = new JTextField();
		this.textFieldStopword.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnOk)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblStopword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.textFieldStopword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStopword)
						.addComponent(this.textFieldStopword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancelar))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		this.contentPane.setLayout(gl_contentPane);
	}
}
