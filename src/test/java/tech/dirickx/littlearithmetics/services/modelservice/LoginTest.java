package tech.dirickx.littlearithmetics.services.modelservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class LoginTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    @WithMockUser(roles = "USER")
//    public void loginWithRoleUserExpectPass() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/quiz/settings"))
//                .andExpect(MockMvcResultMatchers.status().isForbidden());
//    }
}
