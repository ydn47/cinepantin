package fr.demos.pms.model;


public class ExceptionStock extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * NOTE IMPORTANTE: ici il y a un "couplage fort"
     * entre les classes Livre et ExceptionStock (elles se référencent l'une l'autre)
     * Il y a plusieurs manières de se tirer de ce mauvais pas
     * <UL>
     *   <LI> utiliser l'identifiant unique du livre comme référence
     *  <LI> utiliser Object (exception plus générale)
     *  <LI> (Exceptions paramétrées non disponibles pour l'instant)
     *  <LI> meilleure option:utiliser un type interface ... voir plus loin
     *  <LI> créer un type Livre.ExceptionStockLivre qui est spécifique au Livre
     *    (technique des classes enchassées ... voir plus loin...)
     * </UL>
     */
    public final Article article;
    /**
     * NOTE IMPORTANTE: l'état du stock est très "fragile" (il évolue en permanence)
     * entre le moment où l'exception est générée et le moment où elle est exploitée
     * cet état peut avoir évoluer. on a donc besoin d'un "instantané"
     */
    public final int étatStock;
    public final int nbDemandé;

    public ExceptionStock(Article bk, int stock, int req) {
        this.article = bk;
        this.étatStock = stock;
        this.nbDemandé = req;
    }

    @Override
    public String toString() {
        return "StockException: " + this.article +
                ";stock= " + this.étatStock +
                ";demandés= " + this.nbDemandé;
    }

}
