package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.controller.ReachOutController;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.ReachOut;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.ReachOutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class ReachOutControllerTest {

    @Mock
    private ReachOutService reachOutService;

    @Mock
    private Model model;

    @InjectMocks
    private ReachOutController reachOutController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reachOutController).build();
    }

    @Test
    void testShowReachOutForm() throws Exception {
        mockMvc.perform(get("/reachOut"))
                .andExpect(status().isOk())
                .andExpect(view().name("reachOut"));

        verify(model, times(1)).addAttribute("reachOut", new ReachOut());
    }

    @Test
    void testSubmitReachOutForm() throws Exception {
        ReachOut reachOut = new ReachOut();
        reachOut.setId(1);
        reachOut.setName("John Doe");
        reachOut.setEmail("johndoe@example.com");
        reachOut.setMessage("Hello, this is a test message.");

        mockMvc.perform(post("/reachOut")
                        .flashAttr("reachOutPage", reachOut))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/reachOut?success"));

        verify(reachOutService, times(1)).saveMessage(any(ReachOut.class));
    }
}
