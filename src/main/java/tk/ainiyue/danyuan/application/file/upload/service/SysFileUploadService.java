package tk.ainiyue.danyuan.application.file.upload.service;

import java.util.List;

import org.springframework.data.domain.Page;

import tk.ainiyue.danyuan.application.file.upload.po.SysFileUploadInfo;

public interface SysFileUploadService {
	
	void save(SysFileUploadInfo info);
	
	Page<SysFileUploadInfo> findAllBySearchText(int pageNumber, int pageSize, String searchText);
	
	void delete(List<SysFileUploadInfo> list);
	
	/**  
	*  方法名： importSysFileUploadInfo  
	*  功    能： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param info
	*  参    数： @return 
	*  返    回： String  
	*  作    者 ： wang  
	*  @throws  
	*/
	String importSysFileUploadInfo(SysFileUploadInfo info);
	
}
