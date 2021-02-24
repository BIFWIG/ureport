package cn.bif.service;

import cn.bif.vo.TableDataVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ted Wang
 * @created 2021/1/29 11:01 上午
 */
@Service
public class DemoDateService {
    List<TableDataVO> list = new ArrayList<>();
    
    public List<TableDataVO> tableDemoList (String name, String dataSet, Map<String, Object> paramsMap) {
        if (list.isEmpty()) {
            this.initList();
        }
        return list;
    }
    
    
    public List<TableDataVO> filterName (String name, String dataSet, Map<String, Object> paramsMap) {
        Object name1 = paramsMap.get("name");
        if (list.isEmpty()) {
            this.initList();
        }
        if (name1==null) {
            return list;
        }
        List<String> collect1 = Arrays.stream(String.valueOf(name1).split(",")).collect(Collectors.toList());
        return list.stream().filter(tableDataVO -> collect1.contains(tableDataVO.getName())).collect(Collectors.toList());
        
    }
    
    private List<TableDataVO> initList () {
        
        for (int i = 0; i < 10; i++) {
            TableDataVO tableDataVO = new TableDataVO();
            tableDataVO.setName("a" + i);
            tableDataVO.setAge(20 + i);
            tableDataVO.setTitle("Engineer");
            tableDataVO.setAddress("hidden");
            tableDataVO.setWages(BigDecimal.valueOf(Math.random() * 1000000));
            list.add(tableDataVO);
            
        }
        return list;
    }
    
    
}
