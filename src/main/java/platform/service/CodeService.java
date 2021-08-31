package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import platform.model.Code;
import platform.repository.CodeRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodeService {

    private CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code getCode(String uuid) {
        Code code = codeRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No such code found"));

        if (code.getTime() > 0) {
            code.setTime(Duration.between(LocalDateTime.now(),
                    code.getCreationDate().plusSeconds(code.getTime())).getSeconds());
            codeRepository.save(code);
            if (code.getTime() <= 0) {
                codeRepository.delete(code);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such code found");
            }
        }

        long views = code.getViews();
        if (views > 0) {
            views--;
            code.setViews(views);
            codeRepository.save(code);
            if (views <= 0) {
                codeRepository.delete(code);
                return code;
            }
        }
        return code;
    }

    public String postCode(Code newCode) {
        Code code = new Code(newCode.getCode(), LocalDateTime.now(), newCode.getTime(), newCode.getViews());
        codeRepository.save(code);
        return "{ \"id\" : \"" + code.getUuid() + "\" }";
    }

    public Object[] getLatest() {
        List<Code> noRestrictions = new ArrayList<>();
        codeRepository.findAll().forEach(code -> {
            if (code.getTime() <= 0 && code.getViews() <= 0) {
                noRestrictions.add(code);
            }
        });
        List<Code> latestCodes = new ArrayList<>();
        int limit = noRestrictions.size() <= 10 ? 0 : noRestrictions.size() - 10;
        for (int i = noRestrictions.size() - 1; i >= limit ; i--) {
            latestCodes.add(noRestrictions.get(i));
        }
        return latestCodes.toArray();
    }
}