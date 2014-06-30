package fr.demos.pms.test;





import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.demos.pms.model.Article;
import fr.demos.pms.model.ExceptionStock;
import fr.demos.pms.model.LignePanier;
import fr.demos.pms.model.Panier;
import fr.demos.pms.model.Tva;



public class CartTest extends TestCase {
	private Panier panier;
	/** a1 est un article  */
	private Article a1 = new Article("Livre1", "Descriptin du livre1",10.00, Tva.REDUIT, 10);
	private Article a2 = new Article("Livre2", "Descriptin du livre2",20.00, Tva.REDUIT, 10);
	private Article a3 = new Article("Dvd1", "Descriptin du dvd1",24.00, Tva.REDUIT, 10);
	private Article a4 = new Article("Dvd2", "Descriptin du dvd2",14.00, Tva.REDUIT, 10);

	@Before
	public void setUp() throws Exception {
		panier = new Panier(8); //id panier est 8
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testTotalPanier() throws ExceptionStock {
		assertEquals(0.00,panier.getMontantTotalHT(),0.001);
		panier.ajouter(a1, 2); //a1 commande en 2 exemplaires
		assertEquals(20.00,panier.getMontantTotalHT(),0.001);
		panier.ajouter(a2, 1);
		panier.ajouter(a3, 2);
		panier.ajouter(a4, 1);
		assertEquals(102.00,panier.getMontantTotalHT(),0.001);
		panier.retirer(a1);
		assertEquals(82,panier.getMontantTotalHT(),0.001);
	}
	
	@Test
	public void testGetNbArticle() throws ExceptionStock {
		assertEquals(0.00,panier.getLignesPanier().size(),0.001);
		panier.ajouter(a1, 2); //a1 commande en 2 exemplaires
		assertEquals(1,panier.getLignesPanier().size(),0.001);
		panier.ajouter(a1, 1);
		assertEquals(1,panier.getLignesPanier().size(),0.001);
		panier.ajouter(a3, 2);
		panier.ajouter(a4, 1);
		assertEquals(3,panier.getLignesPanier().size(),0.001);
		panier.retirer(a1);
		assertEquals(2,panier.getLignesPanier().size(),0.001);
	}
	
	


}
