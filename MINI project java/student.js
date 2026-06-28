const canvas = document.getElementById('bg-canvas');
const ctx = canvas.getContext('2d');
let W, H, particles = [];
let mx = -9999, my = -9999;
let t = 0;

function resize() {
  W = canvas.width = window.innerWidth;
  H = canvas.height = window.innerHeight;
  initP();
}

window.addEventListener('resize', resize);
window.addEventListener('mousemove', e => { mx = e.clientX; my = e.clientY; });
resize();

function initP() {
  particles = [];
  const n = Math.floor(W * H / 9000);
  for (let i = 0; i < n; i++) {
    particles.push({
      x: Math.random() * W,
      y: Math.random() * H,
      vx: (Math.random() - 0.5) * 0.4,
      vy: (Math.random() - 0.5) * 0.4,
      r: Math.random() * 1.5 + 0.3,
      alpha: Math.random() * 0.5 + 0.1,
      hue: Math.random() < 0.6 ? 186 : 160
    });
  }
}

function drawBg() {
  ctx.clearRect(0, 0, W, H);
  t += 0.006;
  
  const base = ctx.createLinearGradient(0, 0, W, H);
  base.addColorStop(0, '#020408');
  base.addColorStop(0.5, '#030810');
  base.addColorStop(1, '#020408');
  ctx.fillStyle = base;
  ctx.fillRect(0, 0, W, H);
  
  const a1 = ctx.createRadialGradient(
    W * (0.2 + 0.1 * Math.sin(t * 0.7)), H * (0.3 + 0.08 * Math.cos(t * 0.5)), 0,
    W * (0.2 + 0.1 * Math.sin(t * 0.7)), H * (0.3 + 0.08 * Math.cos(t * 0.5)), W * 0.55
  );
  a1.addColorStop(0, 'rgba(0,200,255,0.07)');
  a1.addColorStop(0.4, 'rgba(0,200,255,0.025)');
  a1.addColorStop(1, 'transparent');
  ctx.fillStyle = a1;
  ctx.fillRect(0, 0, W, H);
  
  const a2 = ctx.createRadialGradient(
    W * (0.8 + 0.08 * Math.cos(t * 0.6)), H * (0.6 + 0.1 * Math.sin(t * 0.8)), 0,
    W * (0.8 + 0.08 * Math.cos(t * 0.6)), H * (0.6 + 0.1 * Math.sin(t * 0.8)), W * 0.5
  );
  a2.addColorStop(0, 'rgba(0,255,180,0.055)');
  a2.addColorStop(0.4, 'rgba(0,255,180,0.018)');
  a2.addColorStop(1, 'transparent');
  ctx.fillStyle = a2;
  ctx.fillRect(0, 0, W, H);
  
  const pulse = 0.5 + 0.5 * Math.sin(t * 1.2);
  const a3 = ctx.createRadialGradient(W * 0.5, H * 0.85, 0, W * 0.5, H * 0.85, W * 0.35);
  a3.addColorStop(0, `rgba(255,107,0,${0.03 * pulse})`);
  a3.addColorStop(1, 'transparent');
  ctx.fillStyle = a3;
  ctx.fillRect(0, 0, W, H);
  
  ctx.strokeStyle = 'rgba(0,200,255,0.035)';
  ctx.lineWidth = 0.6;
  const gs = 80;
  for (let x = 0; x < W; x += gs) {
    ctx.beginPath();
    ctx.moveTo(x, 0);
    ctx.lineTo(x, H);
    ctx.stroke();
  }
  for (let y = 0; y < H; y += gs) {
    ctx.beginPath();
    ctx.moveTo(0, y);
    ctx.lineTo(W, y);
    ctx.stroke();
  }
  
  ctx.fillStyle = 'rgba(0,200,255,0.12)';
  for (let x = 0; x <= W; x += gs) {
    for (let y = 0; y <= H; y += gs) {
      ctx.beginPath();
      ctx.arc(x, y, 1, 0, Math.PI * 2);
      ctx.fill();
    }
  }
  
  particles.forEach((p, i) => {
    p.x += p.vx;
    p.y += p.vy;
    if (p.x < -10) p.x = W + 10;
    if (p.x > W + 10) p.x = -10;
    if (p.y < -10) p.y = H + 10;
    if (p.y > H + 10) p.y = -10;
    ctx.beginPath();
    ctx.arc(p.x, p.y, p.r, 0, Math.PI * 2);
    ctx.fillStyle = `hsla(${p.hue},100%,70%,${p.alpha})`;
    ctx.fill();
    for (let j = i + 1; j < particles.length; j++) {
      const q = particles[j];
      const dx = p.x - q.x, dy = p.y - q.y;
      const d = Math.sqrt(dx * dx + dy * dy);
      if (d < 110) {
        const a = (1 - d / 110) * 0.1;
        ctx.beginPath();
        ctx.moveTo(p.x, p.y);
        ctx.lineTo(q.x, q.y);
        ctx.strokeStyle = `rgba(0,200,255,${a})`;
        ctx.lineWidth = 0.5;
        ctx.stroke();
      }
    }
    const mdx = p.x - mx, mdy = p.y - my;
    const md = Math.sqrt(mdx * mdx + mdy * mdy);
    if (md < 140) {
      const a = (1 - md / 140) * 0.25;
      ctx.beginPath();
      ctx.moveTo(p.x, p.y);
      ctx.lineTo(mx, my);
      ctx.strokeStyle = `rgba(0,255,180,${a})`;
      ctx.lineWidth = 0.7;
      ctx.stroke();
    }
  });
  
  requestAnimationFrame(drawBg);
}

drawBg();

class Student {
  constructor(college, name, rollno, age, dept) {
    this.college = college;
    this.name = name;
    this.rollno = parseInt(rollno);
    this.age = parseInt(age);
    this.dept = dept;
  }
  getRollno() { return this.rollno; }
  setDept(d) { this.dept = d; }
  setAge(a) { this.age = parseInt(a); }
  setCollege(c) { this.college = c; }
  display() {
    return `Name: ${this.name} | College: ${this.college} | Dept: ${this.dept} | Roll: ${this.rollno} | Age: ${this.age}`;
  }
}

class StudentManager {
  constructor() { this.list = []; }
  addStudent(s) {
    if (this.list.find(x => x.getRollno() === s.getRollno())) return false;
    this.list.push(s);
    return true;
  }
  viewStudents() { return [...this.list]; }
  searchStudent(rollno) { return this.list.find(s => s.getRollno() === parseInt(rollno)) || null; }
  updateStudent(rollno, college, dept, age) {
    const s = this.searchStudent(rollno);
    if (!s) return false;
    if (dept) s.setDept(dept);
    if (college) s.setCollege(college);
    if (age) s.setAge(age);
    return true;
  }
  deleteStudent(rollno) {
    const idx = this.list.findIndex(s => s.getRollno() === parseInt(rollno));
    if (idx === -1) return false;
    this.list.splice(idx, 1);
    return true;
  }
  count() { return this.list.length; }
  getDepts() { return [...new Set(this.list.map(s => s.dept))]; }
  getColleges() { return [...new Set(this.list.map(s => s.college))]; }
}

const sm = new StudentManager();
let currentUser = null;
let registeredUsers = [];
const ADMIN_CREDS = { username: 'admin', password: 'admin123' };

[
  new Student('Anna University', 'Arjun Kumar', 1001, 20, 'CSE'),
  new Student('SRM University', 'Priya Devi', 1002, 21, 'ECE'),
  new Student('VIT Chennai', 'Karthik Raja', 1003, 22, 'MECH'),
  new Student('Anna University', 'Ananya Singh', 1004, 20, 'IT'),
  new Student('Loyola College', 'Mohammed Rafi', 1005, 23, 'MBA'),
  new Student('SRM University', 'Deepika Nair', 1006, 21, 'AIDS'),
  new Student('PSG Tech', 'Vikram S', 1007, 22, 'EEE'),
  new Student('Anna University', 'Sneha M', 1008, 20, 'CSE'),
].forEach(s => sm.addStudent(s));

function go(page) {
  document.querySelectorAll('.page').forEach(p => p.classList.remove('active'));
  document.getElementById('page-' + page).classList.add('active');
  window.scrollTo(0, 0);
  if (page === 'home') updateHomeStats();
  if (page === 'admin-dash') { renderAdminOverview(); renderAdminTable(); renderUsersTable(); }
  if (page === 'user-dash') { renderUserTable(); renderUserStats(); }
}

function logout() {
  currentUser = null;
  showToast('Logged out successfully', 'info');
  go('home');
}

function updateHomeStats() {
  animCount('s-total', sm.count());
  animCount('s-dept', sm.getDepts().length);
  animCount('s-college', sm.getColleges().length);
}

function animCount(id, target) {
  const el = document.getElementById(id);
  if (!el) return;
  let c = 0;
  const step = Math.max(1, Math.floor(target / 30));
  const iv = setInterval(() => {
    c = Math.min(c + step, target);
    el.textContent = c;
    if (c >= target) clearInterval(iv);
  }, 40);
}

updateHomeStats();

function adminLogin() {
  const un = v('aun'), pw = v('apw');
  if (!un || !pw) { showMsg('admin-err', 'Fill all fields', 'error'); return; }
  if (un === ADMIN_CREDS.username && pw === ADMIN_CREDS.password) {
    currentUser = { name: 'Administrator', email: 'admin@eduvault.edu', role: 'admin' };
    hideMsg('admin-err');
    showToast('⚡ Admin access granted!', 'info');
    go('admin-dash');
  } else {
    showMsg('admin-err', '❌ Invalid credentials. Try admin / admin123', 'error');
    shake('admin-err');
  }
}

function userLogin() {
  const email = v('uemail'), pw = v('upw');
  if (!email || !pw) { showMsg('user-err', 'Fill all fields', 'error'); return; }
  const user = registeredUsers.find(u => u.email === email && u.pw === pw);
  if (user) {
    currentUser = { name: user.fn + ' ' + user.ln, email: user.email, role: 'user', inst: user.inst };
    setupUserDash();
    hideMsg('user-err');
    showToast(`Welcome back, ${user.fn}!`, 'info');
    go('user-dash');
  } else {
    showMsg('user-err', '❌ Invalid email or password', 'error');
  }
}

function guestLogin() {
  currentUser = { name: 'Guest', email: 'guest', role: 'guest' };
  setupUserDash();
  showToast('Logged in as Guest (view only)', 'info');
  go('user-dash');
}

function setupUserDash() {
  const n = currentUser.name;
  document.getElementById('user-display-name').textContent = n;
  document.getElementById('user-avatar').textContent = n.charAt(0).toUpperCase();
  document.getElementById('user-role-badge').textContent = currentUser.role === 'guest' ? 'GUEST' : 'VIEWER';
}

function register() {
  const fn = v('rfn'), ln = v('rln'), em = v('rem'), inst = v('rinst'), pw = v('rpw'), pw2 = v('rpw2');
  hideMsg('reg-ok');
  hideMsg('reg-err');
  if (!fn || !ln || !em || !pw) { showMsg('reg-err', 'Please fill all required fields', 'error'); return; }
  if (pw.length < 6) { showMsg('reg-err', 'Password must be at least 6 characters', 'error'); return; }
  if (pw !== pw2) { showMsg('reg-err', 'Passwords do not match', 'error'); return; }
  if (registeredUsers.find(u => u.email === em)) { showMsg('reg-err', 'Email already registered', 'error'); return; }
  registeredUsers.push({ fn, ln, email: em, inst: inst || '—', pw, joined: new Date().toLocaleDateString() });
  showMsg('reg-ok', '✅ Account created! You can now sign in.', 'success');
  setTimeout(() => go('user-login'), 2000);
}

function addStudent(modal = false) {
  const prefix = modal ? 'm-' : 'a-';
  const name = v(prefix + 'name'), roll = v(prefix + 'roll'),
    college = v(prefix + 'college'), dept = v(prefix + 'dept'), age = v(prefix + 'age');
  const errId = modal ? 'modal-add-err' : 'add-err';
  const okId = modal ? 'modal-add-ok' : 'add-ok';
  hideMsg(errId);
  hideMsg(okId);
  if (!name || !roll || !college || !dept || !age) { showMsg(errId, 'Fill all required fields', 'error'); return; }
  if (isNaN(roll) || isNaN(age)) { showMsg(errId, 'Roll No and Age must be numbers', 'error'); return; }
  const s = new Student(college, name, roll, age, dept);
  if (!sm.addStudent(s)) { showMsg(errId, `Roll No ${roll} already exists!`, 'error'); return; }
  showMsg(okId, `✅ Student "${name}" added successfully!`, 'success');
  showToast(`✅ ${name} added`, 'info');
  [prefix + 'name', prefix + 'roll', prefix + 'college', prefix + 'age'].forEach(id => {
    const el = document.getElementById(id);
    if (el) el.value = '';
  });
  const deptEl = document.getElementById(prefix + 'dept');
  if (deptEl) deptEl.value = '';
  updateHomeStats();
  renderAdminOverview();
  renderAdminTable();
  if (modal) setTimeout(closeModal, 1200);
}

function deleteStudent(roll) {
  if (!confirm(`Delete student with Roll No ${roll}?`)) return;
  if (sm.deleteStudent(roll)) {
    showToast(`🗑️ Student Roll#${roll} deleted`, 'info');
    updateHomeStats();
    renderAdminOverview();
    renderAdminTable();
  }
}

function openEditModal(roll) {
  const s = sm.searchStudent(roll);
  if (!s) return;
  document.getElementById('modal-content').innerHTML = `
    <h3>✏️ Edit Student — Roll #${s.rollno}</h3>
    <div class="form-group"><label>Full Name</label><input id="e-name" value="${s.name}"></div>
    <div class="form-group"><label>College</label><input id="e-college" value="${s.college}"></div>
    <div class="form-row">
      <div class="form-group">
        <label>Department</label>
        <select id="e-dept">
          ${['CSE', 'IT', 'ECE', 'EEE', 'MECH', 'CIVIL', 'AIDS', 'MBA', 'MCA', 'Other'].map(d => `<option ${d === s.dept ? 'selected' : ''}>${d}</option>`).join('')}
        </select>
      </div>
      <div class="form-group"><label>Age</label><input type="number" id="e-age" value="${s.age}"></div>
    </div>
    <button class="btn btn-admin btn-full" onclick="saveEdit(${roll})">💾 Save Changes</button>
    <div class="msg msg-success" id="edit-ok"></div>
  `;
  openModal();
}

function saveEdit(roll) {
  const name = v('e-name'), college = v('e-college'), dept = v('e-dept'), age = v('e-age');
  const s = sm.searchStudent(roll);
  if (!s) return;
  if (name) s.name = name;
  sm.updateStudent(roll, college, dept, age);
  showMsg('edit-ok', '✅ Updated successfully!', 'success');
  showToast('✅ Record updated', 'info');
  renderAdminOverview();
  renderAdminTable();
  setTimeout(closeModal, 1000);
}

function openAddModal() {
  document.getElementById('modal-content').innerHTML = `
    <h3>➕ Add New Student</h3>
    <div class="form-row">
      <div class="form-group"><label>Full Name *</label><input id="m-name" placeholder="Name"></div>
      <div class="form-group"><label>Roll No *</label><input type="number" id="m-roll" placeholder="1001"></div>
    </div>
    <div class="form-group"><label>College *</label><input id="m-college" placeholder="Institution name"></div>
    <div class="form-row">
      <div class="form-group">
        <label>Department *</label>
        <select id="m-dept">
          <option value="">Select</option>
          ${['CSE', 'IT', 'ECE', 'EEE', 'MECH', 'CIVIL', 'AIDS', 'MBA', 'MCA', 'Other'].map(d => `<option>${d}</option>`).join('')}
        </select>
      </div>
      <div class="form-group"><label>Age *</label><input type="number" id="m-age" placeholder="20"></div>
    </div>
    <button class="btn btn-admin btn-full" onclick="addStudent(true)">➕ Add Student</button>
    <div class="msg msg-success" id="modal-add-ok"></div>
    <div class="msg msg-error" id="modal-add-err"></div>
  `;
  openModal();
}

function searchStudent(resultId) {
  const rollId = resultId.startsWith('admin') ? 'srch-roll' : 'user-srch-roll';
  const roll = v(rollId);
  const container = document.getElementById(resultId);
  if (!roll) { container.innerHTML = ''; return; }
  const s = sm.searchStudent(roll);
  if (!s) {
    container.innerHTML = `<div class="card" style="margin-top:1rem;border-color:rgba(255,59,92,0.3)"><p style="color:var(--red);font-family:'JetBrains Mono',monospace;font-size:0.85rem">❌ No student found with Roll No ${roll}</p></div>`;
    return;
  }
  const isAdmin = resultId.startsWith('admin');
  container.innerHTML = `
    <div class="card" style="margin-top:1rem;border-color:rgba(0,200,255,0.3)">
      <div style="display:flex;justify-content:space-between;align-items:flex-start;flex-wrap:wrap;gap:1rem">
        <div>
          <div style="font-family:'Orbitron',sans-serif;font-size:1.1rem;font-weight:900;margin-bottom:0.8rem">🎓 ${s.name}</div>
          <div style="display:grid;gap:0.5rem;font-size:0.88rem">
            <div><span style="color:var(--muted2);font-size:0.75rem;letter-spacing:0.1em;text-transform:uppercase;font-family:'JetBrains Mono',monospace">Roll No</span><br><span style="color:var(--cyan);font-family:'JetBrains Mono',monospace">#${s.rollno}</span></div>
            <div><span style="color:var(--muted2);font-size:0.75rem;letter-spacing:0.1em;text-transform:uppercase;font-family:'JetBrains Mono',monospace">College</span><br>${s.college}</div>
            <div><span style="color:var(--muted2);font-size:0.75rem;letter-spacing:0.1em;text-transform:uppercase;font-family:'JetBrains Mono',monospace">Dept</span><br><span class="td-dept">${s.dept}</span></div>
            <div><span style="color:var(--muted2);font-size:0.75rem;letter-spacing:0.1em;text-transform:uppercase;font-family:'JetBrains Mono',monospace">Age</span><br>${s.age} yrs</div>
          </div>
        </div>
        ${isAdmin ? `<div style="display:flex;flex-direction:column;gap:0.5rem">
          <button class="btn btn-admin btn-sm" onclick="openEditModal(${s.rollno})">✏️ Edit</button>
          <button class="btn btn-danger btn-sm" onclick="deleteStudent(${s.rollno});document.getElementById('${resultId}').innerHTML=''">🗑️ Delete</button>
        </div>` : ''}
      </div>
    </div>`;
}

function renderAdminOverview() {
  const all = sm.viewStudents();
  const depts = sm.getDepts().length;
  const colleges = sm.getColleges().length;
  document.getElementById('admin-stat-cards').innerHTML = `
    <div class="stat-card"><div class="sc-num">${all.length}</div><div class="sc-label">Total Students</div><div class="sc-delta">▲ Active</div></div>
    <div class="stat-card"><div class="sc-num">${depts}</div><div class="sc-label">Departments</div></div>
    <div class="stat-card"><div class="sc-num">${colleges}</div><div class="sc-label">Colleges</div></div>
    <div class="stat-card"><div class="sc-num">${registeredUsers.length}</div><div class="sc-label">Reg. Users</div></div>
  `;
  const recent = all.slice(-5).reverse();
  renderTableBody('admin-recent-tbody', recent, true, 5);
}

function renderAdminTable() {
  const filter = v('admin-filter').toLowerCase();
  let all = sm.viewStudents();
  if (filter) all = all.filter(s =>
    s.name.toLowerCase().includes(filter) ||
    s.dept.toLowerCase().includes(filter) ||
    s.college.toLowerCase().includes(filter) ||
    String(s.rollno).includes(filter)
  );
  document.getElementById('admin-count-badge').textContent = `${all.length} records`;
  renderTableBody('admin-full-tbody', all, true);
}

function renderUserTable() {
  const filter = v('user-filter').toLowerCase();
  let all = sm.viewStudents();
  if (filter) all = all.filter(s =>
    s.name.toLowerCase().includes(filter) ||
    s.dept.toLowerCase().includes(filter) ||
    s.college.toLowerCase().includes(filter) ||
    String(s.rollno).includes(filter)
  );
  document.getElementById('user-count-badge').textContent = `${all.length} records`;
  renderTableBody('user-tbody', all, false);
}

function renderTableBody(id, list, isAdmin, maxRows = 9999) {
  const tbody = document.getElementById(id);
  if (!tbody) return;
  if (!list.length) {
    tbody.innerHTML = `<tr class="empty-row"><td colspan="${isAdmin ? 7 : 6}">// No records found</td></tr>`;
    return;
  }
  tbody.innerHTML = list.slice(0, maxRows).map((s, i) => `
    <tr>
      <td style="color:var(--muted);font-family:'JetBrains Mono',monospace;font-size:0.75rem">${i + 1}</td>
      <td class="td-name">${s.name}</td>
      <td class="td-roll">#${s.rollno}</td>
      <td style="font-size:0.85rem">${s.college}</td>
      <td><span class="td-dept">${s.dept}</span></td>
      <td style="font-size:0.85rem">${s.age}</td>
      ${isAdmin ? `<td><div class="td-actions">
        <button class="btn btn-ghost btn-sm" onclick="openEditModal(${s.rollno})">✏️</button>
        <button class="btn btn-danger btn-sm" onclick="deleteStudent(${s.rollno})">🗑️</button>
      </div></td>` : ''}
    </tr>`).join('');
}

function renderUsersTable() {
  const tbody = document.getElementById('users-tbody');
  if (!registeredUsers.length) {
    tbody.innerHTML = `<tr class="empty-row"><td colspan="6">// No registered users yet</td></tr>`;
    return;
  }
  tbody.innerHTML = registeredUsers.map((u, i) => `
    <tr>
      <td style="color:var(--muted);font-family:'JetBrains Mono',monospace;font-size:0.75rem">${i + 1}</td>
      <td class="td-name">${u.fn} ${u.ln}</td>
      <td style="font-family:'JetBrains Mono',monospace;font-size:0.8rem;color:var(--cyan2)">${u.email}</td>
      <td style="font-size:0.85rem">${u.inst}</td>
      <td><span class="td-dept" style="color:var(--cyan2)">VIEWER</span></td>
      <td style="font-size:0.8rem;color:var(--muted2)">${u.joined}</td>
    </tr>`).join('');
}

function renderUserStats() {
  const all = sm.viewStudents();
  const depts = sm.getDepts().length;
  const colleges = sm.getColleges().length;
  document.getElementById('user-stat-cards').innerHTML = `
    <div class="stat-card"><div class="sc-num">${all.length}</div><div class="sc-label">Total Students</div></div>
    <div class="stat-card"><div class="sc-num">${depts}</div><div class="sc-label">Departments</div></div>
    <div class="stat-card"><div class="sc-num">${colleges}</div><div class="sc-label">Colleges</div></div>
  `;
  const counts = {};
  all.forEach(s => { counts[s.dept] = (counts[s.dept] || 0) + 1; });
  const max = Math.max(...Object.values(counts), 1);
  const colors = ['var(--cyan)', 'var(--cyan2)', 'var(--orange)', 'var(--green)', 'var(--yellow)', 'var(--red)', '#AA80FF', '#FF80AA'];
  document.getElementById('dept-bars').innerHTML = Object.entries(counts).map(([dept, count], i) => `
    <div style="margin-bottom:1rem">
      <div style="display:flex;justify-content:space-between;font-size:0.82rem;margin-bottom:0.4rem">
        <span style="font-weight:700">${dept}</span>
        <span style="color:var(--muted2);font-family:'JetBrains Mono',monospace">${count} students</span>
      </div>
      <div style="height:8px;border-radius:4px;background:rgba(255,255,255,0.05);overflow:hidden">
        <div style="height:100%;width:${(count / max * 100).toFixed(1)}%;background:${colors[i % colors.length]};border-radius:4px;transition:width 0.8s ease;box-shadow:0 0 8px ${colors[i % colors.length]}66"></div>
      </div>
    </div>`).join('');
}

function showPanel(id, el) {
  const dash = document.querySelector('.page.active');
  dash.querySelectorAll('.panel').forEach(p => p.classList.remove('active'));
  dash.querySelectorAll('.sidebar-item').forEach(s => s.classList.remove('active'));
  const panel = document.getElementById('panel-' + id);
  if (panel) panel.classList.add('active');
  dash.querySelectorAll('.sidebar-item').forEach(s => {
    if (s.getAttribute('onclick') && s.getAttribute('onclick').includes(`'${id}'`)) s.classList.add('active');
  });
  if (id === 'admin-overview') renderAdminOverview();
  if (id === 'admin-students') renderAdminTable();
  if (id === 'admin-users') renderUsersTable();
  if (id === 'user-students') renderUserTable();
  if (id === 'user-stats') renderUserStats();
}

function openModal() { document.getElementById('modal-overlay').classList.add('open'); }
function closeModal() { document.getElementById('modal-overlay').classList.remove('open'); }

document.getElementById('modal-overlay').addEventListener('click', function(e) {
  if (e.target === this) closeModal();
});

let toastTimer;
function showToast(msg, type = 'info') {
  const t = document.getElementById('toast');
  t.textContent = (type === 'info' ? 'ℹ️' : type === 'error' ? '❌' : '✅') + ' ' + msg;
  t.className = `toast t-${type} show`;
  clearTimeout(toastTimer);
  toastTimer = setTimeout(() => t.classList.remove('show'), 3000);
}

function v(id) {
  const el = document.getElementById(id);
  return el ? el.value.trim() : '';
}

function showMsg(id, msg, type) {
  const el = document.getElementById(id);
  if (!el) return;
  el.textContent = msg;
  el.className = `msg msg-${type}`;
  el.style.display = 'block';
}

function hideMsg(id) {
  const el = document.getElementById(id);
  if (el) el.style.display = 'none';
}

function shake(id) {
  const el = document.getElementById(id);
  if (!el) return;
  const orig = el.style.transform;
  [0, '-8px', '8px', '-5px', '5px', '0'].forEach((v, i) =>
    setTimeout(() => el.style.transform = `translateX(${v})`, i * 80)
  );
}

function sendContact() {
  const n = v('c-name'), e = v('c-email'), m = v('c-msg');
  if (!n || !e || !m) { showToast('Please fill all required fields', 'error'); return; }
  showMsg('contact-ok', '✅ Message sent! We\'ll reply within 24 hours.', 'success');
  ['c-name', 'c-email', 'c-inst', 'c-msg'].forEach(id => {
    const el = document.getElementById(id);
    if (el) el.value = '';
  });
  setTimeout(() => hideMsg('contact-ok'), 4000);
}

document.addEventListener('keydown', e => {
  if (e.key !== 'Enter') return;
  const pg = document.querySelector('.page.active')?.id;
  if (pg === 'page-admin-login') adminLogin();
  else if (pg === 'page-user-login') userLogin();
  else if (pg === 'page-register') register();
});

updateHomeStats();