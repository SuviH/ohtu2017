/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author suvi
 */
public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    public StatisticsTest() {
    }
    
    @Test
    public void testSearch() {
        assertTrue(stats.search("Semenko")!=null);
        assertTrue(stats.search("suvi")==null);
    }
    @Test
    public void testSearchPalauttaaOikeanPelaajan(){
        Player playa = stats.search("Kurri");
        assertEquals(playa.getTeam(), "EDM");
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        List<Player> pelaajat = stats.team("PIT");
        assertEquals(pelaajat.get(0).getName(), "Lemieux");
    }
    

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        List<Player> parhaat = stats.topScorers(3);
        assertEquals(parhaat.get(0).getName(), "Gretzky");
        assertEquals(parhaat.get(1).getName(), "Lemieux");
        assertEquals(parhaat.get(2).getName(), "Yzerman");
    }
    
}
