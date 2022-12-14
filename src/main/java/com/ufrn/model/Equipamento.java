package com.ufrn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int codigo;
	
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinTable(name = "reserva_equipamento",
	joinColumns = @JoinColumn(name = "equipamento_id"),
	inverseJoinColumns = @JoinColumn(name = "reserva_id"))
	private Set<Reserva> reservas;
	
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private Sala sala;
	
	
	public Equipamento () {
		
	}

	public Equipamento(int codigo, String descricao, Sala sala) {
        super();
        this.codigo = codigo;
        this.descricao = descricao;
        this.sala = sala;
    }



    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
	
	
	
	
}
