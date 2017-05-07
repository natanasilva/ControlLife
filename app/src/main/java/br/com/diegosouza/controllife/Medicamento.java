package br.com.diegosouza.controllife;

import android.os.Parcel;
import android.os.Parcelable;

public class Medicamento implements Parcelable{
    private String descricao;
    private String peridicidade;
    private String horario;
    private String observacao;

    public Medicamento(String descricao, String peridicidade, String horario, String observacao) {
        this.descricao = descricao;
        this.peridicidade = peridicidade;
        this.horario = horario;
        this.observacao = observacao;
    }

    public Medicamento() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPeridicidade() {
        return peridicidade;
    }

    public void setPeridicidade(String peridicidade) {
        this.peridicidade = peridicidade;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    private Medicamento(Parcel in) {
        descricao = in.readString();
        peridicidade = in.readString();
        horario = in.readString();
        observacao = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(descricao);
        dest.writeString(peridicidade);
        dest.writeString(horario);
        dest.writeString(observacao);
    }

    public static final Parcelable.Creator<Medicamento> CREATOR
            = new Parcelable.Creator<Medicamento>() {
        public Medicamento createFromParcel(Parcel in) {
            return new Medicamento(in);
        }

        public Medicamento[] newArray(int size) {
            return new Medicamento[size];
        }
    };

}
