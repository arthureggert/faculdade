package br.com.ahe.dscd.projeto.pvm.trabalho.quimica;


public class ReacaoToIAtomBuilder {
	
	/**private IChemObjectBuilder builder = SilentChemObjectBuilder.getInstance();
	
	public void criaMolecula(String tipo, String nome, String molecula, File diretrio) throws IOException {
		IAtomContainer molecule = builder.newInstance(IAtomContainer.class);

		String[] moleculaSplit = molecula.split("(?=\\p{Lu})");
		for (int i = 0 ; i < moleculaSplit.length ; i++) {
			molecule.addAtom(builder.newInstance(IAtom.class, moleculaSplit[i]));
			molecule.addBond(i, i+1, IBond.Order.SINGLE);
		}
		
		drawMolecule(molecule, diretrio, tipo);
	}
	
	public void drawMolecule(IAtomContainer molecule, File diretrio, String tipo) throws IOException {

		List<IGenerator<IAtomContainer>> generators = new ArrayList<IGenerator<IAtomContainer>>();
		generators.add(new BasicSceneGenerator());
		generators.add(new BasicBondGenerator());
		BasicAtomGenerator atomGenerator = new BasicAtomGenerator();
		generators.add(atomGenerator);

		AtomContainerRenderer renderer = new AtomContainerRenderer(generators, new AWTFontManager());
		RendererModel model = renderer.getRenderer2DModel();
		model.getParameter(CompactShape.class).setValue(Shape.OVAL);
		model.getParameter(CompactAtom.class).setValue(true);
		model.getParameter(KekuleStructure.class).setValue(true);
		model.getParameter(ShowEndCarbons.class).setValue(true);

		Image image = new BufferedImage(400, 400, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = (Graphics2D)image.getGraphics();
		g.setColor(Color.WHITE);
		g.fill(new Rectangle2D.Double(0, 0, 400, 400));

		ElementUtility visitor = new ElementUtility();
		Rectangle screen = new Rectangle(0, 0, 400, 400);
		renderer.setup(molecule, screen);
		renderer.paint(molecule, visitor);
		renderer.paint(molecule, new AWTDrawVisitor(g) , screen, true);
		
		File file = new File(diretrio.getAbsolutePath()+tipo+".png");
        ImageIO.write((RenderedImage)image, "PNG", file);
	}**/

}
