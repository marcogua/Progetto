package Classi;

import DAOImpl.ClienteDaoImp;
import Interfaccie.ClienteInterface;

public class Cliente implements ClienteInterface {
	private String codiceCliente;
    private String nome;
    private String cognome;
    private String email;
    private String codiceTessera;
   
    public Cliente() {
    	this.codiceCliente = null;
    	this.nome = null;
    	this.cognome = null;
    	this.email = null;
    	this.codiceTessera = null;
    }
    public Cliente(String codiceCliente,String nome,String cognome,  String email, String codiceTessera) {
    	this.codiceCliente = codiceCliente;
    	this.nome = nome;
    	this.cognome = cognome;
    	this.email = email;
    	this.codiceTessera = codiceTessera;

    }

    /**
     *
     * @return
     */
    @Override
	public String getCodiceCliente() {
		return codiceCliente;
	}

    /**
     *
     * @param codiceCliente
     */
	@Override
	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

    /**
     *
     * @param codiceCliente
     */
	public Cliente(String codiceCliente) {
        this.codiceCliente= codiceCliente;
    }

    /**
     *
     * @return
     */
    @Override
	public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    @Override
	public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    @Override
	public String getCognome() {
        return cognome;
    }

    /**
     *
     * @param cognome
     */
    @Override
	public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     *
     * @return
     */
    @Override
	public String getCodiceTessera() {
        return codiceTessera;
    }

    /**
     *
     * @param codiceTessera
     */
    @Override
	public void setCodiceTessera(String codiceTessera) {
        this.codiceTessera = codiceTessera;
    }

    /**
     *
     * @return
     */
    @Override
	public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    @Override
	public void setEmail(String email) {
        this.email = email;
    }
    
    
}
