package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CsreplVO;
import com.example.mapper.CsreplMapper;

// Service Class for Csrepl
/**
 *
 * @(#) CsreplService.java
 *
 *
 * @version v0.1
 * @date    2021-10-25
 * @author  TaeHan Heo
 * @since   JDK1.8
 *
 */
@Service
public class CsreplService {

    @Autowired
    private CsreplMapper csreplMapper;

    /**
    * Get one Record 
    * @param long csnum, String ctype, long conum
    * @return CsreplMapper 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public CsreplVO select(long csnum, String ctype, long conum) {
        return csreplMapper.select(csnum, ctype, conum);
    } // end of select
    
    public List<CsreplVO> selectBoards(long csnum, String ctype) {
    	return csreplMapper.selectBoards(csnum, ctype);
    }

    /**
    * Get All Record 
    * @param  List 
    * @return List 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public List<CsreplVO> selectAll() {
        return csreplMapper.selectAll();
    } // end of selectAll

    /**
    * Add Record 
    * @param CsreplVO 
    * @return void 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public void insert(CsreplVO Csrepl) {
        csreplMapper.insert(Csrepl);
    } // end of insert

    /**
    * Update Record 
    * @param CsreplVO 
    * @return void 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public void update(CsreplVO Csrepl) {
        csreplMapper.update(Csrepl);
    } // end of update

    /**
    * Delete Record 
    * @param long csnum, String ctype, long conum
    * @return void 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public void delete(long csnum, String ctype, long conum) {
        csreplMapper.delete(csnum, ctype, conum);
    } // end of delete

    /**
    * Get Rows Count 
    * @param long csnum, String ctype, long conum
    * @return int 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public int count(long csnum, String ctype, long conum) {
        return csreplMapper.count(csnum, ctype, conum);
    } // end of count

    /**
    * Get All Rows Count 
    * @param void 
    * @return int 
    * @author TaeHan Heo 
    * @date 2021-10-25
    */
    public int countAll() {
        return csreplMapper.countAll();
    } // end of countAll
    
    public int countCusid(String cusid) {
    	return csreplMapper.countCusid(cusid);
    } // end of countCusid
    
    public void deleteCusid(String cusid) {
    	csreplMapper.deleteCusid(cusid);
    } // end of deleteCusid
    
    public int getMaxConum(long csnum, String ctype) {
    	return csreplMapper.getMaxConum(csnum, ctype);
    }
    
    @Transactional
    public void addReply(CsreplVO csreplVO) {
    	// ????????? ?????? ???????????? ?????? ?????????(crerf) ?????????
		// ???????????? ??????(cresq)?????? ??? ????????? ????????? 1??? ??????(UPDATE)
    	csreplMapper.updateCresqPlusOne(csreplVO.getCrerf(), csreplVO.getCresq());
    	
    	// insert??? ?????? re????????? ??????
    	csreplVO.setCrelv(csreplVO.getCrelv() + 1);
    	csreplVO.setCresq(csreplVO.getCresq() + 1);
    	
    	
    	// ?????? insert ??????
    	csreplMapper.insert(csreplVO);
    }
} // end of CsreplService class