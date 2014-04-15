package fr.demos.pms.model;

public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name ="idDvd")
	@XmlElement(name="id")
	private long idDvd;
	@Column(name ="titre", updatable=false)
	@XmlElement(name="titre")
	private String titre;
	@Column(name="isbn", updatable=false)
	@XmlElement(name="isbn")
	private String ISBN;
	@Temporal(TemporalType.DATE)
	@Column(name ="dateDeSortie")
	@XmlElement(name="dateDeSortie")
	private Date dateDeSortie;
	@Column(name ="duree")
	@XmlElement(name="duree")
	private String duree;
	@CollectionTable(name="realisateurMapp")
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> realisateurs;
	@CollectionTable(name="acteurMapp")
	@ElementCollection(fetch=FetchType.EAGER)  //par defaut FetchType = lazy cad il ramene pas les valeurs des autres tables
	private List<String> acteurs;
	@Enumerated(EnumType.STRING)
	@XmlElement(name="categorie")
	private Categorie categorie;
	@JoinColumn(name="IdUser")  //le nom de la colone dans la table DVD
	@ManyToOne()
	@XmlElement(name="user")
	private User user;

	protected Dvd(){}


}
