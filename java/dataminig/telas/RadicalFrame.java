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
import br.com.ahe.dataminig.daos.RadicalDAO;
import br.com.ahe.dataminig.tables.Radical;
import constants.AConstants;

public class RadicalFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JTextField textFieldRadical;
	private JTextField textFieldPalavra;
	
	public RadicalFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 272, 123);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		
		JButton btnOk = new JButton("Cadastrar");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RadicalDAO dao = ASpringUtils.getBean( RadicalDAO.class );
				Radical radicalCad = dao.create(new Radical(RadicalFrame.this.textFieldRadical.getText().toLowerCase(), RadicalFrame.this.textFieldPalavra.getText().toLowerCase()));
				JOptionPane.showMessageDialog(null, String.format("Cadastro realizado com sucesso \n%s",radicalCad.toString()));
				setVisible(false);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CancelarAction( AConstants.HIDE, this));
		
		JLabel lblRadical = new JLabel("Radical");
		
		this.textFieldRadical = new JTextField();
		this.textFieldRadical.setColumns(10);
		
		JLabel lblPalavra = new JLabel("Palavra");
		
		this.textFieldPalavra = new JTextField();
		this.textFieldPalavra.setColumns(10);
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRadical)
								.addComponent(lblPalavra))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(this.textFieldPalavra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(this.textFieldRadical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPalavra)
						.addComponent(this.textFieldPalavra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadical)
						.addComponent(this.textFieldRadical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelar)
						.addComponent(btnOk))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		this.contentPane.setLayout(gl_contentPane);
	}
}
