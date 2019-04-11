package com.example.easynotes.model;

import com.example.easynotes.identity.PlayerGameIdentity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "player_game")
@EntityListeners(AuditingEntityListener.class)

public class PlayerGame {
    @EmbeddedId
    private PlayerGameIdentity playerGameIdentity;
    private String start_position;
    private String min;
    private float fgm;
    private float fga;
    private float fg_pct;
    private float fg3m;
    private float fg3a;
    private float fg3_pct;
    private float ftm;
    private float fta;
    private float ft_pct;
    private float o_reb;
    private float d_reb;
    private float reb;
    private float ast;
    private float pf;
    private float stl;
    private float tov;
    private float blk;
    private float pts;
    private float plus_minus;

    public PlayerGame() {
        super();
    }

    public PlayerGame(PlayerGameIdentity playerGameIdentity, String start_position,
                        String min, float fgm,
                        float fga, float fg_pct, float fg3m, float fg3a,
                        float fg3_pct, float ftm, float fta, float ft_pct,
                        float o_reb, float d_reb, float reb, float ast,
                        float pf, float stl, float tov, float blk, float pts,
                        float plus_minus) {
        super();
        this.playerGameIdentity = playerGameIdentity;
        this.start_position = start_position;
        this.min = min;
        this.fgm = fgm;
        this.fga = fga;
        this.fg_pct = fg_pct;
        this.fg3m = fg3m;
        this.fg3a = fg3a;
        this.fg3_pct = fg3_pct;
        this.ftm = ftm;
        this.fta = fta;
        this.ft_pct = ft_pct;
        this.o_reb = o_reb;
        this.d_reb = d_reb;
        this.reb = reb;
        this.ast = ast;
        this.pf = pf;
        this.stl = stl;
        this.tov = tov;
        this.blk = blk;
        this.pts = pts;
        this.plus_minus = plus_minus;
    }

    public PlayerGameIdentity getPlayerGameIdentity() {
        return this.playerGameIdentity;
    }
    public void setPlayerGameIdentity(PlayerGameIdentity playerGameIdentity) {
        this.playerGameIdentity = playerGameIdentity;
    }

    public String getStart_position() {
        return start_position;
    }

    public void setStart_position(String start_position) {
        this.start_position = start_position;
    }

    public float getPlus_minus() {
        return plus_minus;
    }

    public void setPlus_minus(float plus_minus) {
        this.plus_minus = plus_minus;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public float getFgm() {
        return this.fgm;
    }
    public void setFgm(float fgm) {
        this.fgm = fgm;
    }

    public float getFga() {
        return this.fga;
    }
    public void setFga(float fga) {
        this.fga = fga;
    }

    public float getFg_pct() {
        return this.fg_pct;
    }
    public void setFg_pct(float fg_pct) {
        this.fg_pct = fg_pct;
    }

    public float getFg3a() {
        return this.fg3a;
    }
    public void setFg3a(float fg3a) {
        this.fg3a = fg3a;
    }

    public float getFg3m() {
        return this.fg3m;
    }
    public void setFg3m(float fg3m) {
        this.fg3m = fg3m;
    }

    public float getFg3_pct() {
        return this.fg3_pct;
    }
    public void setFg3_pct(float fg3_pct) {
        this.fg3_pct = fg3_pct;
    }

    public float getFtm() {
        return this.ftm;
    }
    public void setFtm(float ftm) {
        this.ftm = ftm;
    }

    public float getFta() {
        return this.fta;
    }
    public void setFta(float fta) {
        this.fta = fta;
    }

    public float getFt_pct() {
        return this.ft_pct;
    }
    public void setFt_pct(float ft_pct) {
        this.ft_pct = ft_pct;
    }

    public float getO_reb() {
        return this.o_reb;
    }
    public void setO_reb(float o_reb) {
        this.o_reb = o_reb;
    }

    public float getD_reb() {
        return this.d_reb;
    }
    public void setD_reb(float d_reb) {
        this.d_reb = d_reb;
    }

    public float getReb() {
        return this.reb;
    }
    public void setReb(float reb) {
        this.reb = reb;
    }

    public float getAst() {
        return this.ast;
    }
    public void setAst(float ast) {
        this.ast = ast;
    }

    public float getBlk() {
        return blk;
    }
    public void setBlk(float blk) {
        this.blk = blk;
    }

    public float getPf() {
        return pf;
    }

    public void setPf(float pf) {
        this.pf = pf;
    }

    public float getPts() {
        return pts;
    }

    public void setPts(float pts) {
        this.pts = pts;
    }


    public float getStl() {
        return stl;
    }

    public void setStl(float stl) {
        this.stl = stl;
    }

    public float getTov() {
        return tov;
    }

    public void setTov(float tov) {
        this.tov = tov;
    }
}
