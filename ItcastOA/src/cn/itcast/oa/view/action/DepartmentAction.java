package cn.itcast.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	private static final long serialVersionUID = 1L;
	private Long parentId;
	
	/** 列表 */
	public String list() throws Exception {
		List<Department> deptList = null;
		if (parentId == null) { // 顶级部门列表
			deptList = deptService.findTopList();
		} else { // 子部门列表
			deptList = deptService.findChildren(parentId);
			Department parent = deptService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("deptList", deptList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		deptService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备数据,deptList
		List<Department> topList = deptService.findTopList();
		List<Department> deptList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("deptList", deptList);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 封装parent到model中
		Department parent = deptService.getById(parentId);
		model.setParent(parent);
		// 保存
		deptService.save(model);

		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备数据,deptList
		List<Department> topList = deptService.findTopList();
		List<Department> deptList = DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("deptList", deptList);
		
		// 准备回显的数据
		Department dept = deptService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(dept);
		if (dept.getParent() != null) {
			parentId = dept.getParent().getId();
		}

		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1.从数据库中获取原对象
		Department dept = deptService.getById(model.getId());

		// 2.设置要修改的属性
		dept.setName(model.getName());
		dept.setDescription(model.getDescription());
		dept.setParent(deptService.getById(parentId)); // 设置所属的上级部门

		// 3.更新到数据库
		deptService.update(dept);

		return "toList";
	}
	
	// ---
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
