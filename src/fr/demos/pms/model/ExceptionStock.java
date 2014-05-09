package fr.demos.pms.model;


public class ExceptionStock extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * NOTE IMPORTANTE: ici il y a un "couplage fort"
     * entre les classes Livre et ExceptionStock (elles se r�f�rencent l'une l'autre)
     * Il y a plusieurs mani�res de se tirer de ce mauvais pas
     * <UL>
     *   <LI> utiliser l'identifiant unique du livre comme r�f�rence
     *  <LI> utiliser Object (exception plus g�n�rale)
     *  <LI> (Exceptions param�tr�es non disponibles pour l'instant)
     *  <LI> meilleure option:utiliser un type interface ... voir plus loin
     *  <LI> cr�er un type Livre.ExceptionStockLivre qui est sp�cifique au Livre
     *    (technique des classes enchass�es ... voir plus loin...)
     * </UL>
     */
    public final Article article;
    /**
     * NOTE IMPORTANTE: l'�tat du stock est tr�s "fragile" (il �volue en permanence)
     * entre le moment o� l'exception est g�n�r�e et le moment o� elle est exploit�e
     * cet �tat peut avoir �voluer. on a donc besoin d'un "instantan�"
     */
    public final int etatStock;
    public final int nbDemande;

    public ExceptionStock(Article bk, int stock, int req) {
        this.article = bk;
        this.etatStock = stock;
        this.nbDemande = req;
    }

    @Override
    public String toString() {
        return "StockException: " + this.article +
                ";stock= " + this.etatStock +
                ";demandes= " + this.nbDemande;
    }

}
