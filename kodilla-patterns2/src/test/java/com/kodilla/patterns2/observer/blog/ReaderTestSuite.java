package com.kodilla.patterns2.observer.blog;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ReaderTestSuite {
    @Test
    public void createAndUseForumTest() {
        // Given
        Reader jacekB = new Reader("Jacek", "Binkul");
        Reader jarekK = new Reader("Jarek", "K.");
        Reader marekJ = new Reader("Marek", "Jurkiewicz");

        Forum computerForum = new ComputerForum();
        Forum micForum = new MicrocontrolerForum();
        Forum vhdlForum = new VhdlForum();

        computerForum.attachReader(jacekB);
        computerForum.attachReader(jarekK);
        computerForum.attachReader(marekJ);
        micForum.attachReader(jacekB);
        micForum.attachReader(jarekK);
        vhdlForum.attachReader(jacekB);


        // When
        computerForum.addBlog(new Blog("Atari", "Atari 65XE on new board ...", LocalDate.now()));
        computerForum.addBlog(new Blog("Commodore", "Commodore with USB port ...", LocalDate.now()));
        micForum.addBlog(new Blog("ATXmega", "ATXmega has new COM10 port ...", LocalDate.now()));
        micForum.addBlog(new Blog("ATmega", "ATmega with PS2 keyboard ...", LocalDate.now()));
        micForum.addBlog(new Blog("ATtiny", "ATtiny for Atari XL/XE ... ...", LocalDate.now()));
        vhdlForum.addBlog(new Blog("Spartan 3E", "ATmega 64 in VHDL ...", LocalDate.now()));
        vhdlForum.addBlog(new Blog("Spartan 3E", "VGA 800x600 driver for atmegas ...", LocalDate.now()));

        System.out.println(jacekB);
        System.out.println(jarekK);
        System.out.println(marekJ);
        System.out.println("\n");

        //Then
        assertEquals(7, jacekB.getBlogs().size());
        assertEquals(5, jarekK.getBlogs().size());
        assertEquals(2, marekJ.getBlogs().size());
    }
}