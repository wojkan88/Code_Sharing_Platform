package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.service.CodeService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CodeController {

    private CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @ResponseBody
    @GetMapping("/api/code/{uuid}")
    public Code getApiCode(@PathVariable String uuid) {
        return codeService.getCode(uuid);
    }

    @ResponseBody
    @GetMapping("/api/code/latest")
    public Object[] getApiLatest() {
        return codeService.getLatest();
    }

    @ResponseBody
    @PostMapping("/api/code/new")
    public String postApiCode(@RequestBody Code newCode) {
        return codeService.postCode(newCode);
    }

    @GetMapping("/code/{uuid}")
    public String getHtmlCode(@PathVariable String uuid, Model model) {
        Code code = codeService.getCode(uuid);
        model.addAttribute("code", code.getCode());
        model.addAttribute("date", code.getDate());
        model.addAttribute("time", code.getTime());
        model.addAttribute("views", code.getViews());
        return "getCode";
    }

    @GetMapping("/code/latest")
    public String getHtmlLatest(Model model) {
        Map<String, Object> latestCodes = new HashMap<>();
        latestCodes.put("snippets", codeService.getLatest());
        model.addAllAttributes(latestCodes);
        return "getLatest";
    }

    @GetMapping("/code/new")
    public String newHtmlCode() {
        return "newCode";
    }
}