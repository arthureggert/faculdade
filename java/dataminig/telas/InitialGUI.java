package br.com.ahe.dataminig.telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import utils.ASpringUtils;
import br.com.ahe.dataminig.actions.CancelarAction;
import br.com.ahe.dataminig.actions.RadicaisAction;
import br.com.ahe.dataminig.actions.SinonimosAction;
import br.com.ahe.dataminig.actions.StopwordAction;
import br.com.ahe.dataminig.textmining.TextMining;

public class InitialGUI {

	private JFrame frame;

	public InitialGUI() {
		initialize();
	}

	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 275);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSeparator verticalSeparator = new JSeparator();
		verticalSeparator.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnSinonimos = new JButton("Sinonimos");
		btnSinonimos.addActionListener(new SinonimosAction());
		
		JButton btnRadicais = new JButton("Radicais");
		btnRadicais.addActionListener(new RadicaisAction());
		
		JButton btnStopword = new JButton("Stopword");
		btnStopword.addActionListener(new StopwordAction());
		
		JSeparator horizontalSeparatorBtn = new JSeparator();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CancelarAction());
		
		final JTextPane textPanePergunta = new JTextPane();
		textPanePergunta.setBorder(new LineBorder(new Color(0, 0, 0)));

		final JTextPane textPaneResultado = new JTextPane();
		textPaneResultado.setEditable(false);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TextMining tMining = ASpringUtils.getBean( TextMining.class );
				tMining.setValue(textPanePergunta.getText().toLowerCase());
				tMining.run();
				textPaneResultado.setText(tMining.getChamados());
			}
		});
		
		JSeparator horizontalSeparator = new JSeparator();
		
		GroupLayout groupLayout = new GroupLayout(this.frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textPanePergunta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
						.addComponent(horizontalSeparator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
						.addComponent(textPaneResultado, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(verticalSeparator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnStopword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRadicais, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSinonimos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(horizontalSeparatorBtn, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(btnOk, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSinonimos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRadicais)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStopword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalSeparatorBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addContainerGap(73, Short.MAX_VALUE))
				.addComponent(verticalSeparator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPanePergunta, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(horizontalSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneResultado, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addContainerGap())
		);
		this.frame.getContentPane().setLayout(groupLayout);
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(true);	
	}
}
