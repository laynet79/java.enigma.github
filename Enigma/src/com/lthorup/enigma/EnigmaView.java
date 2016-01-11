package com.lthorup.enigma;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnigmaView extends JPanel {

	private Enigma enigma = new Enigma();
	/**
	 * Create the panel.
	 */
	public EnigmaView() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(26, 27, 136, 78);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblRotorA = new JLabel("Rotor A");
		lblRotorA.setBounds(45, 6, 61, 16);
		panel.add(lblRotorA);
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(22, 26, 33, 16);
		panel.add(lblType);
		
		JLabel lblOffset = new JLabel("offset");
		lblOffset.setBounds(73, 26, 47, 16);
		panel.add(lblOffset);
	
		SpinnerModel rotorATypeModel = new SpinnerNumberModel(1, 1, 5, 1);
		JSpinner typeA = new JSpinner(rotorATypeModel);
		typeA.setBounds(22, 44, 33, 26);
		panel.add(typeA);
		
		SpinnerModel rotorAOffsetModel = new SpinnerNumberModel(0, 0, 25, 1);
		JSpinner offsetA = new JSpinner(rotorAOffsetModel);
		offsetA.setBounds(67, 44, 49, 26);
		panel.add(offsetA);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(186, 27, 136, 78);
		add(panel_1);
		
		JLabel lblRotorB = new JLabel("Rotor B");
		lblRotorB.setBounds(45, 6, 61, 16);
		panel_1.add(lblRotorB);
		
		JLabel label_1 = new JLabel("type");
		label_1.setBounds(22, 26, 33, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("offset");
		label_2.setBounds(73, 26, 47, 16);
		panel_1.add(label_2);
		
		SpinnerModel rotorBTypeModel = new SpinnerNumberModel(1, 1, 5, 1);
		JSpinner typeB = new JSpinner(rotorBTypeModel);
		typeB.setBounds(22, 44, 33, 26);
		panel_1.add(typeB);
		
		SpinnerModel rotorBOffsetModel = new SpinnerNumberModel(0, 0, 25, 1);
		JSpinner offsetB = new JSpinner(rotorBOffsetModel);
		offsetB.setBounds(67, 44, 49, 26);
		panel_1.add(offsetB);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(346, 27, 136, 78);
		add(panel_2);
		
		JLabel lblRotorC = new JLabel("Rotor C");
		lblRotorC.setBounds(45, 6, 61, 16);
		panel_2.add(lblRotorC);
		
		JLabel label_4 = new JLabel("type");
		label_4.setBounds(22, 26, 33, 16);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("offset");
		label_5.setBounds(73, 26, 47, 16);
		panel_2.add(label_5);
		
		SpinnerModel rotorCTypeModel = new SpinnerNumberModel(1, 1, 5, 1);
		JSpinner typeC = new JSpinner(rotorCTypeModel);
		typeC.setBounds(22, 44, 33, 26);
		panel_2.add(typeC);
		
		SpinnerModel rotorCOffsetModel = new SpinnerNumberModel(0, 0, 25, 1);
		JSpinner offsetC = new JSpinner(rotorCOffsetModel);
		offsetC.setBounds(67, 44, 49, 26);
		panel_2.add(offsetC);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(511, 27, 74, 78);
		add(panel_3);
		
		JLabel lblReflector = new JLabel("Reflector");
		lblReflector.setBounds(6, 6, 61, 16);
		panel_3.add(lblReflector);
		
		JLabel label_7 = new JLabel("type");
		label_7.setBounds(22, 26, 33, 16);
		panel_3.add(label_7);
		
		SpinnerModel reflectorTypeModel = new SpinnerNumberModel(1, 1, 3, 1);
		JSpinner typeR = new JSpinner(reflectorTypeModel);
		typeR.setBounds(22, 44, 33, 26);
		panel_3.add(typeR);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 154, 559, 88);
		add(scrollPane);
		
		JTextArea inputTxt = new JTextArea();
		scrollPane.setViewportView(inputTxt);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 293, 559, 88);
		add(scrollPane_1);
		
		JTextArea outputTxt = new JTextArea();
		scrollPane_1.setViewportView(outputTxt);
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setBounds(26, 127, 61, 16);
		add(lblInput);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setBounds(26, 265, 61, 16);
		add(lblOutput);
		
		JButton btnEncode = new JButton("Encode/Decode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rotorTypeA = (int)typeA.getValue();
				int rotorOffsetA = (int)offsetA.getValue();
				int rotorTypeB = (int)typeB.getValue();
				int rotorOffsetB = (int)offsetB.getValue();
				int rotorTypeC = (int)typeC.getValue();
				int rotorOffsetC = (int)offsetC.getValue();
				int reflectorType = (int)typeR.getValue();
				enigma.configure(rotorTypeA-1, rotorTypeB-1, rotorTypeC-1, reflectorType-1, rotorOffsetA, rotorOffsetB, rotorOffsetC);
				outputTxt.setText(enigma.encode(inputTxt.getText()));
			}
		});
		btnEncode.setBounds(233, 403, 140, 29);
		add(btnEncode);

	}
}
